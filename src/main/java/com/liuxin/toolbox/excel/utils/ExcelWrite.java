package com.liuxin.toolbox.excel.utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * excel写操作
 * @author lucky
 *
 */
public class ExcelWrite {
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";
    
 
    /**
     * 创建一个excel <br>
     * @param dataSheets
     * @param file
     * @throws IOException
     */
    public void writeExcel(Map<String, List<List<String>>> dataSheets,String path) throws IOException {
      
      Workbook workBook = null;
      OutputStream out = null;
      File file = new File(path);
      try {
      workBook = getWriteWorkbok(file);
      Set<Entry<String, List<List<String>>>> entrySet = dataSheets.entrySet();
      for (Entry<String, List<List<String>>> dataSheet : entrySet) {
        //创建sheet
        Sheet sheet = workBook.createSheet(dataSheet.getKey());
        List<List<String>> list = dataSheet.getValue();
        if(list != null) {
          for (int i = 0; i < list.size(); i++) {
            //创建行
            Row row = sheet.createRow(i);
            List<String> dataRow = list.get(i);
            if(dataRow != null) {
              for (int j = 0; j < dataRow.size(); j++) {
                //创建单元格
                Cell cell = row.createCell(j);
                cell.setCellValue(dataRow.get(j));
              }
            }
          }
        }
        
    }
      out =  new FileOutputStream(file);
        workBook.write(out);
      }finally {
        if(workBook != null) {
          workBook.close();
        }
        if(out != null) {
          out.close();
        }
      }
    }
    
    
    /**
     * 判断Excel的版本,获取Workbook
     * @param file
     * @return
     * @throws IOException
     */
    private  Workbook getWriteWorkbok(File file) throws IOException{
      
        Workbook wb = null;
        if(file.getName().endsWith(EXCEL_XLS)){     
            wb = new HSSFWorkbook();
        }else if(file.getName().endsWith(EXCEL_XLSX)){    
            wb = new XSSFWorkbook();
        }
        return wb;
    }
 
}
