/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：ExcelWriterTool.java
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
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 将数据集合导出到excel文件中，如果数据集合为空则生成只有标题的模板文件
 *
 * @author Administrator
 */
public class ExcelWriterTool {

    private OutputStream out;
    private XSSFWorkbook wb;
    boolean ignore = true;

    /**
     * 构造方法
     *
     * @param out 数据写入流
     */
    public ExcelWriterTool(OutputStream out) {
        this.out = out;
        wb = new XSSFWorkbook();
    }

    public ExcelWriterTool(OutputStream out, boolean ignore) {
        this.out = out;
        wb = new XSSFWorkbook();
        this.ignore = ignore;
    }

    public void writeList(List<?> list, Class<?> clazz) {
        try {
            if (!clazz.isAnnotationPresent(TableMeta.class)) {
                return;
            }

            TableMeta tableMeta = clazz.getAnnotation(TableMeta.class);

            // 获得需要转换的字段
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

            sheet.setDefaultColumnWidth((short) 30);// 列的宽度

            // 必填项表头字体
            XSSFCellStyle cellStyle = wb.createCellStyle();
            cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            XSSFFont font = wb.createFont();
            font.setColor(IndexedColors.RED.getIndex());
            font.setBold(true);
            cellStyle.setFont(font);

            // 非必填项表头字体
            XSSFCellStyle cellStyle2 = wb.createCellStyle();
            cellStyle2.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            cellStyle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
            cellStyle2.setAlignment(HorizontalAlignment.CENTER);
            XSSFFont font2 = wb.createFont();
            font2.setBold(true);
            cellStyle2.setFont(font2);

            // 文本格式单元格
            XSSFCellStyle textCellStyle = wb.createCellStyle();
            XSSFDataFormat textDataFormat = wb.createDataFormat();
            textCellStyle.setDataFormat(textDataFormat.getFormat("@"));

            XSSFRow titleRow = sheet.createRow(0); // 创建第一行，并在该行创建单元格，设置内容，做为标题行
            titleRow.setHeight((short) 400);

            for (int i = 0; i < fieldList.size(); i++) {
                XSSFCell cell = null;
                FieldMeta fMeta = null;

                cell = titleRow.createCell(i);
                Field field = fieldList.get(i);
                fMeta = field.getAnnotation(FieldMeta.class);
                cell.setCellValue(fMeta.name());

                if (fMeta.nullable()) {
                    cell.setCellStyle(cellStyle2);// 非必填项表头字体
                } else {
                    cell.setCellStyle(cellStyle);// 必填项表头字体
                }

                // FIXME
//                // 生成字典下拉框
//                if (!isEmpty(fMeta.dictNo())) {
//                    List<Dict> dictList = DictTag.getChildren(fMeta.dictNo());
//                    List<String> values = new ArrayList<String>();
//
//                    if (dictList != null && !dictList.isEmpty()) {
//                        for (Dict dict : dictList) {
//                            values.add(dict.getDictName());
//                        }
//                    }
//
//                    /*
//                     * DVConstraint constraint =
//                     * DVConstraint.createExplicitListConstraint(values.toArray(
//                     * new String[]{})); CellRangeAddressList regions = new
//                     * CellRangeAddressList(1, 10000, i,i); HSSFDataValidation
//                     * dataValidation = new HSSFDataValidation(regions,
//                     * constraint); sheet.addValidationData(dataValidation);
//                     */
//
//                    if (CheckEmptyUtil.isNotEmpty(values)) {
//                        DataValidationHelper helper = sheet.getDataValidationHelper();
//                        DataValidationConstraint constraint = helper
//                                .createExplicitListConstraint(values.toArray(new String[]{}));
//                        CellRangeAddressList addressList = new CellRangeAddressList(1, 100000, i, i);
//                        DataValidation dataValidation = helper.createValidation(constraint, addressList);
//                        sheet.addValidationData(dataValidation);
//                    }
//
//                }
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

                // 生成数据集合下拉框
                if (CheckEmptyUtil.isNotEmpty(fMeta.dataArray()) && isEmpty(fMeta.dictNo())) {
                    /*
                     * DVConstraint constraint =
                     * DVConstraint.createExplicitListConstraint(fMeta.dataArray
                     * ()); CellRangeAddressList regions = new
                     * CellRangeAddressList(1, 10000, i,i); HSSFDataValidation
                     * dataValidation = new HSSFDataValidation(regions,
                     * constraint); sheet.addValidationData(dataValidation);
                     */

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
//                        // 字典转换
//                        if (value != null && !isEmpty(fMeta.dictNo())) {
//                            value = DictTag.dictName(fMeta.dictNo(), value.toString());
//                        }

                        // 数据集合判断
                        if (value != null && CheckEmptyUtil.isNotEmpty(fMeta.dataArray()) && isEmpty(fMeta.dictNo())) {
                            if (!ArrayUtils.contains(fMeta.dataArray(), value)) {
                                value = "";
                            }
                        }

                        // 日期转换
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
            out.flush();
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
     * 写入数据集合
     *
     * @param list  数据集合
     * @param clazz 需要转换的类
     */
    public void writeListToExcel(List<LinkedHashMap<String, Object>> list, Class<?> clazz) {
        try {
            if (!clazz.isAnnotationPresent(TableMeta.class)) {
                return;
            }

            TableMeta tableMeta = clazz.getAnnotation(TableMeta.class);

            // 获得需要转换的字段
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

            sheet.setDefaultColumnWidth((short) 30);// 列的宽度

            // 必填项表头字体
            XSSFCellStyle cellStyle = wb.createCellStyle();
            cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            XSSFFont font = wb.createFont();
            font.setColor(IndexedColors.RED.getIndex());
            font.setBold(true);
            cellStyle.setFont(font);

            // 非必填项表头字体
            XSSFCellStyle cellStyle2 = wb.createCellStyle();
            cellStyle2.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            cellStyle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
            cellStyle2.setAlignment(HorizontalAlignment.CENTER);
            XSSFFont font2 = wb.createFont();
            font2.setBold(true);
            cellStyle2.setFont(font2);

            // 文本格式单元格
            XSSFCellStyle textCellStyle = wb.createCellStyle();
            XSSFDataFormat textDataFormat = wb.createDataFormat();
            textCellStyle.setDataFormat(textDataFormat.getFormat("@"));
            XSSFRow titleRow = sheet.createRow(0); // 创建第一行，并在该行创建单元格，设置内容，做为标题行
            titleRow.setHeight((short) 400);
            for (int i = 0; i < fieldList.size(); i++) {
                // 如果遍历到最后一个字段，则再添加一个单元格
                XSSFCell cell = null;
                FieldMeta fMeta = null;
                cell = titleRow.createCell(i);
                Field field = fieldList.get(i);
                fMeta = field.getAnnotation(FieldMeta.class);
                cell.setCellValue(fMeta.name());

                if (fMeta.nullable()) {
                    cell.setCellStyle(cellStyle2);// 非必填项表头字体
                } else {
                    cell.setCellStyle(cellStyle);// 必填项表头字体
                }

                // FIXME
//                // 生成字典下拉框
//                if (!isEmpty(fMeta.dictNo())) {
//                    List<Dict> dictList = DictTag.getChildren(fMeta.dictNo());
//                    List<String> values = new ArrayList<String>();
//
//                    if (dictList != null && !dictList.isEmpty()) {
//                        for (Dict dict : dictList) {
//                            values.add(dict.getDictName());
//                        }
//                    }
//
//                    /*
//                     * DVConstraint constraint =
//                     * DVConstraint.createExplicitListConstraint(values.toArray(
//                     * new String[]{})); CellRangeAddressList regions = new
//                     * CellRangeAddressList(1, 10000, i,i); HSSFDataValidation
//                     * dataValidation = new HSSFDataValidation(regions,
//                     * constraint); sheet.addValidationData(dataValidation);
//                     */
//
//                    if (CheckEmptyUtil.isNotEmpty(values)) {
//                        DataValidationHelper helper = sheet.getDataValidationHelper();
//                        DataValidationConstraint constraint = helper
//                                .createExplicitListConstraint(values.toArray(new String[]{}));
//                        CellRangeAddressList addressList = new CellRangeAddressList(1, 100000, i, i);
//                        DataValidation dataValidation = helper.createValidation(constraint, addressList);
//                        sheet.addValidationData(dataValidation);
//                    }
//
//                }

                // 生成数据集合下拉框
                if (CheckEmptyUtil.isNotEmpty(fMeta.dataArray()) && isEmpty(fMeta.dictNo())) {
                    /*
                     * DVConstraint constraint =
                     * DVConstraint.createExplicitListConstraint(fMeta.dataArray
                     * ()); CellRangeAddressList regions = new
                     * CellRangeAddressList(1, 10000, i,i); HSSFDataValidation
                     * dataValidation = new HSSFDataValidation(regions,
                     * constraint); sheet.addValidationData(dataValidation);
                     */

                    DataValidationHelper helper = sheet.getDataValidationHelper();
                    DataValidationConstraint constraint = helper.createExplicitListConstraint(fMeta.dataArray());
                    CellRangeAddressList addressList = new CellRangeAddressList(1, 100000, i, i);
                    DataValidation dataValidation = helper.createValidation(constraint, addressList);
                    sheet.addValidationData(dataValidation);
                }

                if (ignore == false && i == fieldList.size() - 1) {
                    cell = titleRow.createCell(i + 1);
                    cell.setCellValue("错误原因");
                }
            }

            if (list != null && !list.isEmpty()) {
                List<List<LinkedHashMap<String, Object>>> totals = getFinalListMap(list, 1000);
                for (List<LinkedHashMap<String, Object>> data : totals) {
                    //System.out.println("[[[[[[[[[[[[[[[[[[[[[["+data.size());
                    int rowIndex = 1;
                    // for (Object obj : list) {
                    for (LinkedHashMap<String, Object> map : data) {
                        XSSFRow row = sheet.createRow(rowIndex);
                        for (int i = 0; i < fieldList.size(); i++) {
                            XSSFCell cell = row.createCell(i);
                            Field field = fieldList.get(i);
                            field.setAccessible(true);

                            // Object value = field.get(obj);
                            Object value = map.get(field.getName());
                            FieldMeta fMeta = field.getAnnotation(FieldMeta.class);

                            // FIXME
//                            // 字典转换
//                            if (value != null && !isEmpty(fMeta.dictNo())) {
//                                value = DictTag.dictName(fMeta.dictNo(), value.toString());
//                            }

                            // 数据集合判断
                            if (value != null && CheckEmptyUtil.isNotEmpty(fMeta.dataArray())
                                    && isEmpty(fMeta.dictNo())) {
                                if (!ArrayUtils.contains(fMeta.dataArray(), value)) {
                                    value = "";
                                }
                            }

                            // 日期转换
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

                            // ＴＯＤＯ 遍历到最后一列的时候把错误信息赋值到excel
                            if (ignore == false && i == fieldList.size() - 1) {
                                if (map.containsKey("errorMessage")) {
                                    cell = row.createCell(i + 1);
                                    cell.setCellValue(map.get("errorMessage").toString());
                                }

                            }
                        }
                        rowIndex++;
                    }
                }
            }

            wb.write(out);
            out.flush();
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

    // 批量导入大数据集合拆分 以limit为单位进行拆分
    public List<List<LinkedHashMap<String, Object>>> getFinalListMap(List<LinkedHashMap<String, Object>> sourceList,
                                                                     int limit) {
        try {
            List<List<LinkedHashMap<String, Object>>> targetList = new ArrayList<>();
            List<LinkedHashMap<String, Object>> subList = null;
            int len = sourceList.size();
            if (CheckEmptyUtil.isNotEmpty(sourceList)) {
                if (len <= limit) {
                    targetList.add(sourceList);
                } else {
                    int count = len / limit;
                    int mod = len % limit;
                    if (mod != 0) {
                        count += 1;
                    }
                    for (int i = 0; i < count; i++) {
                        subList = new ArrayList<>();
                        // 如果剩余的数据不够limit长度，则将其整体放到targetList
                        if (i == count - 1 && (len - (limit * i)) != limit) {
                            subList = sourceList.subList(limit * i, len);
                        } else {
                            subList = sourceList.subList(limit * i, (limit * (i + 1)));
                        }
                        targetList.add(subList);

                    }

                }
            }
            return targetList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean isEmpty(String str) {
        if (str == null || str.trim().equals("")) {
            return true;
        }
        return false;
    }

}
