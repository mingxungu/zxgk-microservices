/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：ExcelReaderTool.java
 * 修改记录：
 * 1.2019年10月10日，PingTech：创建
 */

package cn.com.pingtech.poi;

import cn.com.pingtech.utils.CheckEmptyUtil;
import cn.com.pingtech.utils.DateUtils;
import cn.com.pingtech.utils.IdcardUtil;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

/**
 * Excel读数据工具类
 *
 * @author Administrator
 */
public class ExcelReaderTool {

    private Workbook workbook;
    private InputStream in;

    // FIXME
//    private Map<String, List<Dict>> map = new HashMap<>();
//    private List<Dict> dictList;

    /**
     * 构造方法
     *
     * @param in        Excel文件输入流
     * @param excelType Excel类型(ExcelType.Excel_2003支持扩展名为.xls的文件，ExcelType.Excel_2007支持扩展名为.xlsx的文件)
     * @throws IOException
     */
    public ExcelReaderTool(InputStream in, ExcelType excelType) throws IOException {
        this.in = in;
        if (excelType == ExcelType.Excel_2003) {
            workbook = new HSSFWorkbook(in);
        } else if (excelType == ExcelType.Excel_2007) {
            workbook = new XSSFWorkbook(in);
        }
    }

    public void addErrorInfo(Map<String, Object> info, String message) {
        info.put("errorCode", message);
    }

    /**
     * 从文件中读出所有数据并返回数据集合
     *
     * @param clazz            需要转化的类
     * @param errorMessageList 错误记录集合，对每条数据进行验证，如果存在不规则的数据会将提示信息保持到该集合中
     * @return 返回验证通过的记录集合
     * @throws Exception
     */
    public Map<String, Object> readList(Class<?> clazz) throws Exception {
        List<Object> list = new ArrayList<Object>();
        Map<Object, String> m = new HashMap<>();
        Map<Object, String> keym = new HashMap<>();
        Map<String, Object> result = new HashMap<>();
        List<Map<String, Object>> errorList = new ArrayList<>();//

        try {
            if (!clazz.isAnnotationPresent(TableMeta.class)) {
                addErrorInfo(result, clazz.getName() + "类存在无效的注解，无法解析数据。");
                return result;
            }

            TableMeta tableMeta = clazz.getAnnotation(TableMeta.class);

            Sheet sheet = workbook.getSheetAt(0);
            ;
            if (sheet == null) {
                addErrorInfo(result, "在Excel中无法找到页数据。");
                return result;

            }

            int rowNum = sheet.getLastRowNum();
            if (rowNum == 0) {
                addErrorInfo(result, "数据为空，不能导入。");
                return result;

            }

            if (rowNum > tableMeta.maxCount()) {
                addErrorInfo(result, "数据过多，请分批导入(每次不超过" + tableMeta.maxCount() + "条)。");
                return result;

            }

            StringBuilder fieldNames = new StringBuilder();
            StringBuilder headerNames = new StringBuilder();

            //获取需要解析的字段
            List<Field> fieldList = new ArrayList<Field>();
            //保存主键字段
            List<Field> keyFieldList = new ArrayList<Field>();
            Field[] fields = clazz.getDeclaredFields();
            FieldMeta fieldMeta = null;
            for (Field field : fields) {
                if (field.isAnnotationPresent(FieldMeta.class)) {
                    fieldMeta = field.getAnnotation(FieldMeta.class);
                    fieldList.add(field);

                    fieldNames.append(fieldMeta.name());
                    //保存主键到主键集合中
                    if (fieldMeta.key()) {
                        keyFieldList.add(field);
                    }
                }
            }

            if (fieldList.size() == 0) {
                addErrorInfo(result, clazz.getName() + "类中字段没有配置注解。");
                return result;
            }

            Row rowHeader = sheet.getRow(0);
            for (Cell cell : rowHeader) {
                if (!"错误原因".equals(cell.getStringCellValue().trim())) {
                    headerNames.append(cell.getStringCellValue().trim());
                }

            }

            //验证表头数据和需要解析的字段顺序是否一致
            if (tableMeta.checkTitle()) {
                if (!fieldNames.toString().equals(headerNames.toString())) {
                    addErrorInfo(result, "表头验证失败，请下载模板。");
                    return result;
                }
            }

            //文件第一行为表头信息，从2行开始解析数据
            for (int i = 1; i <= rowNum; i++) {//TODO 此处使用多线程并发校验  提高效率

                Object entity = clazz.newInstance();//每一行数据构建一个实体对象

                Row rowData = sheet.getRow(i);
                Map<String, Object> errorData = new LinkedHashMap<>();
                StringBuilder errorMessage = new StringBuilder();//保存每列对象验证的错误提示
                //String lineName = "第" + (i+1) + "行：" ;

                //解析每列数据
                for (int j = 0; j < fieldList.size(); j++) {

                    Field field = fieldList.get(j);

                    field.setAccessible(true);
                    FieldMeta fMeta = field.getAnnotation(FieldMeta.class);
                    Cell cell = rowData.getCell(j);
                    Object value = getValue(cell);
                    //System.out.println("value================="+value);


                    if (value != null && field.getType() != Date.class) {//需要字典转换或者日期转换的不直接添加到map中，经过后面的处理后再添加
                        //System.out.println("value=================     "+j+ "   ....   "+value.toString());
                        errorData.put(field.getName(), value.toString());
                    } else {
                        errorData.put(field.getName(), "");
                    }

                    if (!fMeta.nullable() && isEmpty(value)) {
                        errorMessage.append(fMeta.name() + "的值不能为空。");
                        continue;
                    }

                    //验证唯一字段是否重复
                    if (fMeta.unique()) {
                        if (isEmpty(value)) {
                            errorMessage.append(fMeta.name() + "的值不能为空。");
                            continue;
                        }
                        if (CheckEmptyUtil.isEmpty(m)) {
                            m.put(value, fMeta.name());
                        } else {
                            if (CheckEmptyUtil.isNotEmpty(m.get(value))) {
                                errorMessage.append(fMeta.name() + "重复。");
                                continue;
                            }
                            m.put(value, fMeta.name());
                        }
                    }
                    /**
                     * 身份证严格验证
                     */
                    if (fMeta.isIdCard() && !isEmpty(value)) {
                        boolean isidcard = IdcardUtil.isIdcard(value.toString());
                        if (!isidcard) {
                            errorMessage.append(fMeta.name() + "的值无效。");
                            continue;
                        }
                    }

                    // FIXME
//                    //字典类型转换
//                    if (!isEmpty(fMeta.dictNo()) && !isEmpty(value)) {
//                        if (CheckEmptyUtil.isEmpty(map) || (CheckEmptyUtil.isNotEmpty(map) && CheckEmptyUtil.isEmpty(map.get(fMeta.dictNo())))) {
//                            dictList = DictTag.getChildren(fMeta.dictNo());
//                            map.put(fMeta.dictNo(), dictList);
//                        } else {
//                            dictList = map.get(fMeta.dictNo());
//                        }
//                        boolean flag = true;
//                        for (Dict dict : dictList) {
//                            if (value.equals(dict.getDictName())) {
//                                value = dict.getDictValue();
//                                errorData.put(field.getName(), value);
//                                flag = false;
//                                break;
//                            }
//                        }
//                        if (flag) {
//                            errorMessage.append(fMeta.name() + "的值不在有效的范围内。");
//                            continue;
//                        }
//                    }
//                    /**字典类型不转换  直接入库dictName,该字段为可下拉值或者自定义值 */
//                    if (!isEmpty(fMeta.dictNo2()) && !isEmpty(value)) {
//                        List<Dict> dictList = DictTag.getChildren(fMeta.dictNo());
//                        for (Dict dict : dictList) {
//                            if (value.equals(dict.getDictName())) {
//                                break;
//                            }
//                        }
//                    }
                    //数据集合判断
                    if (!isEmpty(value) && CheckEmptyUtil.isNotEmpty(fMeta.dataArray())) {
                        if (!ArrayUtils.contains(fMeta.dataArray(), value)) {
                            errorMessage.append(fMeta.name() + "的值不在有效的范围内。");
                            continue;
                        }
                    }

                    //日期类型转换
                    if (!isEmpty(value) && field.getType() == Date.class) {
                        //目前只应用于审批模块修改校验,其余模块保持不变   @linyd  2019.1.20
                        if (cell.getCellType() == 0) {//日期类型
                            if (clazz.toString().contains("FlowExemptionCar") ||
                                    clazz.toString().contains("FlowWhiteCar") ||
                                    clazz.toString().contains("FlowMajorCar") ||
                                    clazz.toString().contains("FlowMajorPeople")) {
                                String reg = "^\\d{2}-\\S{2,3}-\\d{4}$";
                                if (value.toString().matches(reg)) {
                                    value = cell.getDateCellValue();
                                    errorData.put(field.getName(), value);
                                } else {
                                    errorMessage.append(fMeta.name() + "的值格式错误。");
                                    continue;
                                }
                            } else {
                                value = cell.getDateCellValue();
                                errorData.put(field.getName(), value);
                            }
                        } else {//字符串格式日期只支持下面两种格式
                            if (value.toString().matches("^\\d{4}-\\d{2}-\\d{2}$")) {
                                value = DateUtils.parseDate(value.toString(), "yyyy-MM-dd");
                                errorData.put(field.getName(), value);
                            } else if (value.toString().matches("^\\d{4}-\\d{2}-\\d{2}\\s+\\d{2}:\\d{2}:\\d{2}$")) {
                                value = DateUtils.parseDate(value.toString(), "yyyy-MM-dd HH:mm:ss");
                                errorData.put(field.getName(), value);
                            } else {
                                errorMessage.append(fMeta.name() + "的值格式错误。");
                                continue;
                            }
                        }
                    }

                    //数字类型转换
                    if (!isEmpty(value) && (field.getType() == Integer.class || field.getType() == Long.class || field.getType() == Float.class
                            || field.getType() == Double.class || field.getType() == int.class || field.getType() == long.class || field.getType() == float.class
                            || field.getType() == double.class)) {
                        if (value.toString().matches("^\\d+[.]?\\d*$")) {
                            BigDecimal bigDecimal = new BigDecimal(value.toString());
                            if (field.getType() == Integer.class || field.getType() == int.class) {
                                value = bigDecimal.intValue();
                            }
                            if (field.getType() == Long.class || field.getType() == long.class) {
                                value = bigDecimal.longValue();
                            }
                            if (field.getType() == Float.class || field.getType() == float.class) {
                                value = bigDecimal.floatValue();
                            }
                            if (field.getType() == Double.class || field.getType() == double.class) {
                                value = bigDecimal.doubleValue();
                            }
                        } else {
                            errorMessage.append(fMeta.name() + "必须是数字格式。");
                            continue;
                        }
                    }
                    if (!isEmpty(value) && field.getType() == String.class) {
                        if (fMeta.isPhoneNo()) {
                            String valueStr = value.toString();
                            if (valueStr.contains(".0")) {
                                valueStr = valueStr.replace(".0", "");
                            }
                            if (valueStr.contains("E")) {
                                valueStr = valueStr.replace(".", "");
                                /**当用科学计数法表示时，避免末位为0时电话号码报错或末位缺失的情况  **/
                                int lengthBeforE = valueStr.substring(0, valueStr.indexOf("E")).length();
                                int realLength = Integer.valueOf(valueStr.substring(valueStr.indexOf("E") + 1, valueStr.length()));
                                int lastZeroFix = realLength + 1 - lengthBeforE;
                                valueStr = valueStr.substring(0, valueStr.indexOf("E"));
                                StringBuffer sb = new StringBuffer(valueStr);
                                for (int n = 0; n < lastZeroFix; n++) {
                                    sb.append("0");
                                }
                                valueStr = sb.toString();
                            }
                            value = valueStr.toString();

                        } else {
                            if (cell.getCellTypeEnum() != CellType.STRING) {
                                errorMessage.append(fMeta.name() + "必须是文本格式。");
                                continue;
                            }
                        }
                    }

                    if (!isEmpty(value) && field.getType() != Date.class) {
                        //正则校验
                        if (!isEmpty(fMeta.regex())) {
                            if (!value.toString().matches(fMeta.regex())) {
                                errorMessage.append(fMeta.name() + "的值无效。");
                                continue;
                            }
                        }

                        //长度校验
                        if (fMeta.maxLength() > 0) {
                            if (value.toString().length() > fMeta.maxLength()) {
                                errorMessage.append(fMeta.name() + "的值长度大于" + fMeta.maxLength() + "。");
                                continue;
                            }
                        }
                    }

                    if (!isEmpty(value)) {
                        field.set(entity, value);
                    }

                    //每一行最后一个字段遍历时，如果有错误信息，则将错误信息加到map最后一列
                    if (j == fieldList.size() - 1 && errorMessage.length() != 0) {
                        errorData.put("errorMessage", errorMessage);
                        //errorListbak.add(errorData);
                    }


                }
                //验证主键是否重复
                if (tableMeta.keyEnabled()) {
                    if (CheckEmptyUtil.isNotEmpty(keyFieldList)) {
                        String valueString = "";
                        String titleString = "";
                        for (Field f : keyFieldList) {
                            f.setAccessible(true);
                            FieldMeta fm = f.getAnnotation(FieldMeta.class);
                            Object v = f.get(entity);
                            if (v == null || "".equals(v.toString().trim())) {
                                errorMessage.append(fm.name() + "的值不能为空。");
                                errorData.put("errorMessage", errorMessage);
                            } else {
                                valueString += v.toString();
                                titleString = titleString + fm.name() + "+";
                            }
                        }

                        if (titleString.length() > 0) {
                            titleString = titleString.substring(0, titleString.length() - 1);
                        }

                        if (errorMessage.length() == 0) {
                            if (CheckEmptyUtil.isEmpty(keym)) {
                                keym.put(valueString, titleString);
                            } else {
                                if (CheckEmptyUtil.isNotEmpty(keym.get(valueString))) {
                                    errorMessage.append(titleString + "重复。");
                                    errorData.put("errorMessage", errorMessage);
                                }
                                keym.put(valueString, titleString);
                            }

                        }
                    }
                }

                if (errorMessage.length() == 0) {//验证通过的数据保存到返回集合中
                    try {
                        list.add(entity);
                    } catch (Exception e) {
                        e.printStackTrace();
                        errorMessage.append("数据解析错误。");
                    }
                } else {//验证失败的记录，保持错误提示到错误记录集合中
                    errorList.add(errorData);

                }
            }

            result.put("data", list);
            result.put("errorList", errorList);
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            //addMessage(errorMessageList,"数据解析错误。");
            return null;
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }


    private void addMessage(List<String> errorMessageList, String message) {
        if (errorMessageList != null) {
            errorMessageList.add(message);
        }
    }

    private Object getValue(Cell cell) throws Exception {
        if (cell == null) {
            return null;
        }
        return StringUtils.deleteWhitespace(String.valueOf(cell));
    }

    private boolean isEmpty(Object obj) {
        if (obj == null || obj.toString().trim().equals("")) {
            return true;
        }
        return false;
    }

    public enum ExcelType {
        Excel_2007, Excel_2003
    }

    public Map<String, Object> objectToMap(Object obj) {
        if (obj == null) {
            return null;
        }
        return new BeanMap(obj);

    }

    public static void main(String[] args) throws Exception {
		/*FileInputStream in = new FileInputStream("D:/word/poi/test01.xls");
		ExcelReader read = new ExcelReader(in,ExcelReader.ExcelType.Excel_2003);
		List<WhiteCar> list = (List<WhiteCar>)read.readList(WhiteCar.class, null);
		System.out.println(JSON.toJSONString(list));*/

    }
}
