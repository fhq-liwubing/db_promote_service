package com.db.promote.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExcelUtil {

    private static final Logger log = LoggerFactory.getLogger(ExcelUtil.class);

    public static final String OFFICE_EXCEL_2003_POSTFIX = "xls";

	public static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";

    private static final int MAX_COLUMN_WIDTH = 255; // Excel文件最大列宽(字符数)

	public static final String EMPTY = "";

	public static final String POINT = ".";

	/**
	 * 去文件后缀
	 * @param path
	 * @return
	 */
	public static String getPostfix(String path) {
		if (path == null || EMPTY.equals(path.trim())) {
			return EMPTY;
		}
		if (path.contains(POINT)) {
			return path.substring(path.lastIndexOf(POINT) + 1, path.length());
		}
		return EMPTY;
	}

	/**
	 * 解析EXCEL、数据转换
	 * @param hssfCell
	 * @return
	 */
	public static String getValue(HSSFCell hssfCell) {
		String value ="";
		if(hssfCell != null){
		 switch (hssfCell.getCellType()) {
         case HSSFCell.CELL_TYPE_NUMERIC: // 数字、日期
        	 if(hssfCell.toString().indexOf("-")!=-1){
        		 SimpleDateFormat  sd = new SimpleDateFormat("yyyy-MM-dd");
        		 value = sd.format(hssfCell.getDateCellValue());
        	 }else{
        		 DecimalFormat df = new DecimalFormat("#");
        		 value = String.valueOf(df.format(hssfCell.getNumericCellValue())) ;
        	 }
             break;
         case HSSFCell.CELL_TYPE_STRING: // 字符串
             value = hssfCell.getStringCellValue() ;
             break;
         case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
        	 value = String.valueOf(hssfCell.getBooleanCellValue() );
             break;
         case HSSFCell.CELL_TYPE_FORMULA: // 公式
             System.out.print(hssfCell.getCellFormula() + "   ");
             break;
         case HSSFCell.CELL_TYPE_BLANK: // 空值
             break;
         case HSSFCell.CELL_TYPE_ERROR: // 故障
             break;
         default:
             value="--";
             break;
         }
		}
		 return value;
	}

	/**
     * 创建excel文档，
     * @param list 数据
     * @param keys list中map的key数组集合
     * @param columnNames excel的列名
     * */
    public static Workbook createWorkBook(List<Map<String, Object>> list,
    		String[] keys, String[] columnNames) {
        // 创建excel工作簿
        Workbook wb = new HSSFWorkbook();
        // 创建第一个sheet(页)并命名
        Sheet sheet = wb.createSheet(list.get(0).get("sheetName").toString());
        // 手动设置列宽,第一个参数表示要为第几列设,第二个参数表示列的宽度,n为列高的像素数
        for(int i=0;i<keys.length;i++){
            sheet.setColumnWidth((short) i, (short) (35.7 * 150));
        }
        // 创建第一行
        Row row = sheet.createRow((short) 0);
        // 创建两种单元格格式
        CellStyle cs = wb.createCellStyle();
        CellStyle cs2 = wb.createCellStyle();
        // 创建两种字体
        Font f = wb.createFont();
        Font f2 = wb.createFont();
        // 创建第一种字体样式(用于列名)
        f.setFontHeightInPoints((short) 10);
        f.setColor(IndexedColors.BLACK.getIndex());
        f.setBoldweight(Font.BOLDWEIGHT_BOLD);
        // 创建第二种字体样式(用于值)
        f2.setFontHeightInPoints((short) 10);
        f2.setColor(IndexedColors.BLACK.getIndex());
        // 设置第一种单元格的样式(用于列名)
        cs.setFont(f);
        cs.setBorderLeft(CellStyle.BORDER_THIN);
        cs.setBorderRight(CellStyle.BORDER_THIN);
        cs.setBorderTop(CellStyle.BORDER_THIN);
        cs.setBorderBottom(CellStyle.BORDER_THIN);
        cs.setAlignment(CellStyle.ALIGN_CENTER);
        // 设置第二种单元格的样式(用于值)
        cs2.setFont(f2);
        cs2.setBorderLeft(CellStyle.BORDER_THIN);
        cs2.setBorderRight(CellStyle.BORDER_THIN);
        cs2.setBorderTop(CellStyle.BORDER_THIN);
        cs2.setBorderBottom(CellStyle.BORDER_THIN);
        cs2.setAlignment(CellStyle.ALIGN_CENTER);
        //设置列名
        for(int i=0;i<columnNames.length;i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(columnNames[i]);
            cell.setCellStyle(cs);
        }
        //设置每行每列的值
        for (short i = 1; i < list.size(); i++) {
            // Row行,Cell方格, Row和Cell都是从0开始计数的
            // 创建一行,在页sheet上
            Row row1 = sheet.createRow((short) i);
            // 在row行上创建一个方格
            for(short j=0;j<keys.length;j++){
                Cell cell = row1.createCell(j);
                cell.setCellValue(list.get(i).get(keys[j]) == null?" ": list.get(i).get(keys[j]).toString());
                cell.setCellStyle(cs2);
            }
        }
        return wb;
    }


    /**
     * 生成excel对象
     *
     * @param excelName
     * @param titles
     * @param data
     * @return
     */
    public static HSSFWorkbook generateWorkbook(String excelName, String[] titles, List<Object[]> data) {
        HSSFWorkbook workBook = generateWorkbook(excelName, titles, data, null);
        return workBook;
    }

    /**
     * 生成excel对象
     *
     * @param excelName
     * @param titles
     * @param data
     * @return
     */
    public static HSSFWorkbook generateWorkbook(String excelName, String[] titles, List<Object[]> data,
                                                String firstLine) {
        HSSFWorkbook workBook = new HSSFWorkbook();
        HSSFSheet sheet = workBook.createSheet(excelName);
        HSSFCellStyle style = workBook.createCellStyle();

        if (titles != null) {
            int contentStartIndex = 0;

            if (!StringUtils.isEmpty(firstLine)) {// 第一行有提示语句
                contentStartIndex = 1;
                HSSFRow firstRow = sheet.createRow(0);// 第0行
                HSSFCell cell = firstRow.createCell(0);// 单元格
                cell.setCellValue(firstLine);// 设置第一行的值
                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, titles.length - 1));// 合并单元格
                HSSFCellStyle cellStyle = workBook.createCellStyle();
                cellStyle.setWrapText(true);
                cell.setCellStyle(cellStyle);
                // firstRow.setHeight((short)550);
            }

            // 初始化列宽
            int[] columWidth = new int[titles.length];
            for (int i = 0; i < titles.length; i++) {
                columWidth[i] = 0;
            }

            HSSFRow titleRow = sheet.createRow(contentStartIndex);
            for (int i = 0, size = titles.length; i < size; i++) {
                HSSFCell cell = titleRow.createCell(i);
                cell.setCellValue(titles[i]);

                // 计算列宽
                int width = getStringDisplayLength(titles[i]);
                if (width > columWidth[i]) {
                    columWidth[i] = width;
                }

            }
            contentStartIndex++;
            if (data != null && data.size() != 0) {// 写入Excel数据
                for (int i = 0, size = data.size(); i < size; i++) {
                    HSSFRow row = sheet.createRow(contentStartIndex + i);
                    for (int j = 0; j < data.get(i).length; j++) {
                        HSSFCell cell = row.createCell(j);
                        Object object = data.get(i)[j];
                        if (object == null) {
                            continue;
                        }
                        if (object instanceof Integer) {
                            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                            cell.setCellValue((Integer) object);
                        } else if (object instanceof Long) {
                            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                            cell.setCellValue((Long) object);
                        } else if (object instanceof Float) {
                            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                            cell.setCellValue((Float) object);
                        } else if (object instanceof Double) {
                            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                            cell.setCellValue((Double) object);
                        } else if (object instanceof Date) {
                            DataFormat format = workBook.createDataFormat();
                            style.setDataFormat(format.getFormat("yyyy-MM-dd HH:mm:ss"));
                            cell.setCellStyle(style);
                            cell.setCellValue((Date) object);
                        } else {
                            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                            cell.setCellValue(object.toString());
                        }

                        // 计算列宽
                        int width = getStringDisplayLength(object.toString());
                        if (width > columWidth[j]) {
                            columWidth[j] = width;
                        }
                    }
                }
            }

            // 设置列宽
            for (int i = 0; i < titles.length; i++) {
                int width = columWidth[i] + 2;
                width = width > MAX_COLUMN_WIDTH ? MAX_COLUMN_WIDTH : width;
                sheet.setColumnWidth(i, width * 256);
            }
        }
        return workBook;
    }

    /**
     * 计算字符串宽度，统计每个字符：ASCII码127以下记作1，以上记作2
     */
    private static int getStringDisplayLength(String string) {

        int length = 0;

        if (string == null || string.length() == 0) {
            return length;
        }

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c > 127) {
                length += 2;
            } else {
                length++;
            }
        }

        return length;
    }


    public static void exportExcel(HSSFWorkbook workBook, String excelName,String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        excelName = path + excelName;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(excelName + ".xls");
            workBook.write(fos);
        } catch (IOException e) {
            log.info("Excel导出工具出错" + e.getMessage());
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                log.info("关闭输出流出错" + e.getMessage());
            }
        }
    }

}
