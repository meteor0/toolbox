package com.liuxin.toolbox.excel.convertsql.factory.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.helpers.MessageFormatter;

import com.liuxin.toolbox.excel.convertsql.bean.ReqExcelVO;
import com.liuxin.toolbox.excel.utils.ExcelRead;

public interface ReadExcelToSql {

  /**转换读取到的excel原始数据,转换成list*/
  List<List<String>> convertExcelDate(ReqExcelVO reqExcelVO);

  
  /**读取excel,获取数据*/
  default List<List<String>> excelToSqlData(String filePath) throws IOException {
    List<List<String>> value = new ArrayList<>();
    Map<String, List<List<String>>> result = ExcelRead.readExcel(filePath);
    Iterator<Entry<String, List<List<String>>>> iterator = result.entrySet().iterator();
    while (iterator.hasNext()) {
      Entry<String, List<List<String>>> sheet = iterator.next();
      value = sheet.getValue();
      value.remove(0);
      break;
    }
    return value;
  }
  
  void outPrintSql(ReqExcelVO reqExcelVO);

  //统一写sql
  default void outPrintSql(String sql,Object[] argumentArray) {
    String message2 = MessageFormatter.arrayFormat(sql, argumentArray).getMessage();
    System.out.println(message2+";");
  }
  
}
