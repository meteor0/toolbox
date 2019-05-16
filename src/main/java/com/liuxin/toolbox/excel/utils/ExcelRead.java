package com.liuxin.toolbox.excel.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
  private static final String EXCEL_XLS = "xls";
  private static final String EXCEL_XLSX = "xlsx";



  /**
   * 读取Excel
   * 
   * @param path
   * @return
   * @throws IOException
   */
  public static Map<String, List<List<String>>> readExcel(String path) throws IOException {

    Workbook workbook = getWriteWorkbok(path);
    // excel数据, key是sheet的名字
    Map<String, List<List<String>>> dataSheets = new HashMap<>();
    // Read the Sheet
    for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
      Sheet sheet = workbook.getSheetAt(numSheet);
      if (sheet == null) {
        continue;
      }
      // excel中一个sheet的数据
      List<List<String>> dataSheet = new ArrayList<>();
      dataSheets.put(sheet.getSheetName(), dataSheet);

      for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
        Row row = sheet.getRow(rowNum);
        if (row != null) {
          // excel的一行数据
          List<String> dataRow = new ArrayList<>();
          dataSheet.add(dataRow);
          Iterator<Cell> it = row.cellIterator();
          while (it.hasNext()) {
            dataRow.add(getValue(it.next()));
          }
        }
      }
    }
    return dataSheets;
  }

  /**
   * 获取单元格的值
   * 
   * @param row
   * @return
   */
  private static String getValue(Cell row) {
    if (row.getCellType() == CellType.BOOLEAN) {
      return String.valueOf(row.getBooleanCellValue());
    } else if (row.getCellType() == CellType.NUMERIC) {
      if (HSSFDateUtil.isCellDateFormatted(row)) {
        Date date = row.getDateCellValue();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
      }
      return String.valueOf(row.getNumericCellValue());
    } else {
      return String.valueOf(row.getStringCellValue());
    }
  }

  /**
   * 判断Excel的版本,获取Workbook
   * 
   * @param file
   * @return
   * @throws IOException
   */
  private static Workbook getWriteWorkbok(String path) throws IOException {
    if (path == null) {
      throw new IOException("找不到文件，文件路径可能是null");
    }
    InputStream is = new FileInputStream(path);

    if (path.endsWith(EXCEL_XLS)) {
      return new HSSFWorkbook(is);
    }
    if (path.endsWith(EXCEL_XLSX)) {
      return new XSSFWorkbook(is);
    }

    is.close();
    throw new IOException(path + " 不是Excel文件");
  }
}
