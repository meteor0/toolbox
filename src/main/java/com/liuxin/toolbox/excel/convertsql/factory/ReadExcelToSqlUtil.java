package com.liuxin.toolbox.excel.convertsql.factory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

import com.liuxin.toolbox.excel.convertsql.bean.ReqDataToPrintSqlVO;
import com.liuxin.toolbox.excel.convertsql.bean.ReqReadExceToDatalVO;
import com.liuxin.toolbox.excel.utils.ExcelRead;

public class ReadExcelToSqlUtil {

  static Logger logger = LoggerFactory.getLogger(ReadExcelToSqlUtil.class);

  public static List<List<String>> convertExcelToDate(ReqReadExceToDatalVO reqReadExceToDatalVO) {
    String filePath = reqReadExceToDatalVO.getFilePath();
    List<List<String>> resultList = null;
    try {
      List<List<String>> value = excelToSqlData(filePath);
      resultList = new ArrayList<>(value.size());
      for (int i = 0; i < value.size(); i++) {
        List<String> result = new ArrayList<>();
        List<String> list = value.get(i);
        for (int k = 0; k < reqReadExceToDatalVO.getCols().size(); k++) {
          Integer index = reqReadExceToDatalVO.getCols().get(k);
          if (index < list.size()) {
            result.add(list.get(index));
          }
        }
        resultList.add(result);
      }
    } catch (IOException e) {
      logger.error("读取excel文件错误,文件路径:{}", filePath, e);
    }
    return resultList;
  }
  
  
  /**读取excel,获取原始数据*/
  private static List<List<String>> excelToSqlData(String filePath) throws IOException {
    List<List<String>> value = new ArrayList<>();
    Map<String, List<List<String>>> result = ExcelRead.readExcel(filePath);
    Iterator<Entry<String, List<List<String>>>> iterator = result.entrySet().iterator();
    while (iterator.hasNext()) {
      Entry<String, List<List<String>>> sheet = iterator.next();
      value = sheet.getValue();
      value.remove(0); //去掉excel表头
      break;
    }
    return value;
  }
  
  
  /**输出 sql */
  public static void outPrintSql(List<ReqDataToPrintSqlVO> reqSqlList) {
    for (ReqDataToPrintSqlVO reqDataToPrintSqlVO : reqSqlList) {
      String sqlTemplate = reqDataToPrintSqlVO.getSqlTemplate();
      List<String> sqlValues = reqDataToPrintSqlVO.getSqlValues();
      String[] argumentArray = (String[]) sqlValues.toArray(new String[sqlValues.size()]);
      outPrintSql(argumentArray, sqlTemplate);
    }
  }
  
  public static void outPrintSql(String[] argumentArray,String sqlTemplate){
    FormattingTuple message = MessageFormatter.arrayFormat(sqlTemplate, argumentArray);
    System.out.println(message.getMessage()+";\n");
  }
}
