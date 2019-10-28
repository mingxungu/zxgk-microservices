/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：ExcelWriter.java
 * 修改记录：
 * 1.2019年10月10日，PingTech：创建
 */

package cn.com.pingtech.poi;

import cn.com.pingtech.utils.CheckEmptyUtil;
import cn.com.pingtech.utils.DateUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.*;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将数据集合导出到excel文件中，如果数据集合为空则生成只有标题的模板文件
 *
 * @author Administrator
 */
public class ExcelWriter {

    private OutputStream out;
    private XSSFWorkbook wb;

    /**
     * 构造方法
     *
     * @param out 数据写入流
     */
    public ExcelWriter(OutputStream out) {
        this.out = out;
        wb = new XSSFWorkbook();
    }

    /**
     * 写入数据集合
     *
     * @param list  数据集合
     * @param clazz 需要转换的类
     */
    public void writeList(List<?> list, Class<?> clazz) {
        try {
            if (!clazz.isAnnotationPresent(TableMeta.class)) {
                return;
            }

            TableMeta tableMeta = clazz.getAnnotation(TableMeta.class);

            //获得需要转换的字段
            List<Field> fieldList = new ArrayList<Field>();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(FieldMeta.class)) {
                    fieldList.add(field);
                }
            }

            if (fieldList.isEmpty()) {
                return;
            }

            XSSFSheet sheet = wb.createSheet(tableMeta.name());

            sheet.setDefaultColumnWidth((short) 30);//列的宽度

            //必填项表头字体
            XSSFCellStyle cellStyle = wb.createCellStyle();
            cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            XSSFFont font = wb.createFont();
            font.setColor(IndexedColors.RED.getIndex());
            font.setBold(true);
            cellStyle.setFont(font);

            //非必填项表头字体
            XSSFCellStyle cellStyle2 = wb.createCellStyle();
            cellStyle2.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            cellStyle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
            cellStyle2.setAlignment(HorizontalAlignment.CENTER);
            XSSFFont font2 = wb.createFont();
            font2.setBold(true);
            cellStyle2.setFont(font2);

            //文本格式单元格
            XSSFCellStyle textCellStyle = wb.createCellStyle();
            XSSFDataFormat textDataFormat = wb.createDataFormat();
            textCellStyle.setDataFormat(textDataFormat.getFormat("@"));

            XSSFRow titleRow = sheet.createRow(0); // 创建第一行，并在该行创建单元格，设置内容，做为标题行
            titleRow.setHeight((short) 400);

            for (int i = 0; i < fieldList.size(); i++) {
                XSSFCell cell = titleRow.createCell(i);
                Field field = fieldList.get(i);
                FieldMeta fMeta = field.getAnnotation(FieldMeta.class);
                cell.setCellValue(fMeta.name());

                if (fMeta.nullable()) {
                    cell.setCellStyle(cellStyle2);//非必填项表头字体
                } else {
                    cell.setCellStyle(cellStyle);//必填项表头字体
                }

                // FIXME
//                //生成字典下拉框
//                if (!isEmpty(fMeta.dictNo())) {
//                    List<Dict> dictList = DictTag.getChildren(fMeta.dictNo());
//                    List<String> values = new ArrayList<String>();
//
//                    if (dictList != null && !dictList.isEmpty()) {
//                        for (Dict dict : dictList) {
//                            values.add(dict.getDictName());
//                        }
//                    }
//            		/*DVConstraint constraint = DVConstraint.createExplicitListConstraint(values.toArray(new String[]{}));
//		            CellRangeAddressList regions = new CellRangeAddressList(1, 10000, i,i);
//		            HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
//		            sheet.addValidationData(dataValidation);*/
//                    if (CheckEmptyUtil.isNotEmpty(values)) {
//                        DataValidationHelper helper = sheet.getDataValidationHelper();
//                        DataValidationConstraint constraint = helper.createExplicitListConstraint(values.toArray(new String[]{}));
//                        CellRangeAddressList addressList = new CellRangeAddressList(1, 100000, i, i);
//                        DataValidation dataValidation = helper.createValidation(constraint, addressList);
//                        sheet.addValidationData(dataValidation);
//                    }
//                }
//
//                //生成字典下拉框2
//                if (!isEmpty(fMeta.dictNo2())) {
//                    List<Dict> dictList = DictTag.getChildren(fMeta.dictNo2());
//                    List<String> values = new ArrayList<String>();
//
//                    if (dictList != null && !dictList.isEmpty()) {
//                        for (Dict dict : dictList) {
//                            values.add(dict.getDictName());
//                        }
//                    }
//                    if (CheckEmptyUtil.isNotEmpty(values)) {
//                        DataValidationHelper helper = sheet.getDataValidationHelper();
//                        DataValidationConstraint constraint = helper.createExplicitListConstraint(values.toArray(new String[]{}));
//                        CellRangeAddressList addressList = new CellRangeAddressList(1, 100000, i, i);
//                        DataValidation dataValidation = helper.createValidation(constraint, addressList);
//                        sheet.addValidationData(dataValidation);
//                    }
//                }

                //生成数据集合下拉框
                if (CheckEmptyUtil.isNotEmpty(fMeta.dataArray()) && isEmpty(fMeta.dictNo())) {
            		/*DVConstraint constraint = DVConstraint.createExplicitListConstraint(fMeta.dataArray());
		            CellRangeAddressList regions = new CellRangeAddressList(1, 10000, i,i);
		            HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
		            sheet.addValidationData(dataValidation);*/

                    DataValidationHelper helper = sheet.getDataValidationHelper();
                    DataValidationConstraint constraint = helper.createExplicitListConstraint(fMeta.dataArray());
                    CellRangeAddressList addressList = new CellRangeAddressList(1, 100000, i, i);
                    DataValidation dataValidation = helper.createValidation(constraint, addressList);
                    sheet.addValidationData(dataValidation);
                }
            }

            if (list != null && !list.isEmpty()) {
                int rowIndex = 1;
                for (Object obj : list) {
                    XSSFRow row = sheet.createRow(rowIndex);
                    for (int i = 0; i < fieldList.size(); i++) {
                        XSSFCell cell = row.createCell(i);
                        Field field = fieldList.get(i);
                        field.setAccessible(true);

                        Object value = field.get(obj);
                        FieldMeta fMeta = field.getAnnotation(FieldMeta.class);

                        // FIXME
//                        //字典转换
//                        if (value != null && !isEmpty(fMeta.dictNo())) {
//                            value = DictTag.dictName(fMeta.dictNo(), value.toString());
//                        }

                        //数据集合判断
                        if (value != null && CheckEmptyUtil.isNotEmpty(fMeta.dataArray()) && isEmpty(fMeta.dictNo())) {
                            if (!ArrayUtils.contains(fMeta.dataArray(), value)) {
                                value = "";
                            }
                        }

                        //日期转换
                        if (value != null && value instanceof Date) {
                            if (isEmpty(fMeta.format())) {
                                value = "";
                            } else {
                                value = DateUtils.formatDate((Date) value, fMeta.format());
                            }
                        }

                        cell.setCellStyle(textCellStyle);
                        if (value != null) {
                            cell.setCellValue(value.toString());
                        } else {
                            cell.setCellValue("");
                        }
                    }
                    rowIndex++;
                }
            }

            wb.write(out);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (wb != null) {
                    wb.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 查获明细统计数据报表导出
     *
     * @param list      数据集合
     * @param titleList 需要转换表格标题集合
     * @param name      数据页名称
     * @author xucf in 2019-4-3
     */
    public void writeList(List<Map<String, Object>> list, List<String> titleList, String name) {
        try {
            if (titleList.isEmpty()) {
                return;
            }
            int len = titleList.size();
            // 定义 sheet
            XSSFSheet sheet = wb.createSheet(name);
            // 设置列宽
            sheet.setDefaultColumnWidth((short) 30);

            // 必填的表头字体
            XSSFCellStyle cellStyle = wb.createCellStyle();
            cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            XSSFFont font = wb.createFont();
            font.setColor(IndexedColors.RED.getIndex());
            font.setBold(true);
            cellStyle.setFont(font);

            //非必填项表头字体
            XSSFCellStyle cellStyle2 = wb.createCellStyle();
            cellStyle2.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            cellStyle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
            cellStyle2.setAlignment(HorizontalAlignment.CENTER);
            XSSFFont font2 = wb.createFont();
            font2.setBold(true);
            cellStyle2.setFont(font2);

            //文本格式单元格
            XSSFCellStyle textCellStyle = wb.createCellStyle();
            XSSFDataFormat textDataFormat = wb.createDataFormat();
            textCellStyle.setDataFormat(textDataFormat.getFormat("@"));

            // 创建第一行，并在该行创建单元格，设置内容，做为标题行
            XSSFRow titleRow = sheet.createRow(0);
            titleRow.setHeight((short) 400);

            for (int i = 0; i < len; i++) {
                XSSFCell cell = titleRow.createCell(i);
                // 设置每列标题
                cell.setCellValue(titleList.get(i));
                // 必填项表头字体
                cell.setCellStyle(cellStyle);
            }

            if (list != null && !list.isEmpty()) {
                int rowIndex = 1;
                for (Map<String, Object> map : list) {
                    XSSFRow row = sheet.createRow(rowIndex);
                    for (int i = 0; i < len; i++) {
                        XSSFCell cell = row.createCell(i);
                        Object value;
                        if (i == len - 1) {
                            // 最后一列,key 为 其它,title是其它物品
                            value = map.get("其它");
                        } else {
                            // 其它列 为 物品名称(单位)
                            String title = titleList.get(i);
                            String key = title.split("\\(")[0];
                            value = map.get(key);
                        }
                        cell.setCellStyle(textCellStyle);
                        if (value != null) {
                            // 数值转换成 字符串
                            String str = String.valueOf(value);
                            if (str.endsWith(".000") || str.endsWith(".00") || str.endsWith(".0")) {
                                str = str.split("\\.")[0];
                            }
                            cell.setCellValue(str);
                        } else {
                            cell.setCellValue("0");
                        }
                    }
                    rowIndex++;
                }
            }

            wb.write(out);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (wb != null) {
                    wb.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private boolean isEmpty(String str) {
        if (str == null || str.trim().equals("")) {
            return true;
        }
        return false;
    }

}
