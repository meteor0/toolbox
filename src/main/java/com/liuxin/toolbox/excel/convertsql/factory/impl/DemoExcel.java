package com.liuxin.toolbox.excel.convertsql.factory.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liuxin.toolbox.excel.convertsql.bean.ReqExcelVO;

public class DemoExcel implements ReadExcelToSql {


  Logger logger = LoggerFactory.getLogger(getClass());

  @Override
  public List<List<String>> convertExcelDate(ReqExcelVO reqExcelVO) {
    String filePath = reqExcelVO.getFilePath();
    List<List<String>> resultList = null;
    try {
      List<List<String>> value = excelToSqlData(filePath);
      resultList = new ArrayList<>(value.size());
      for (int i = 0; i < value.size(); i++) {
        List<String> result = new ArrayList<>();
        List<String> list = value.get(i);
        for (int k = 0; k < reqExcelVO.getCols().size(); k++) {
          Integer index = reqExcelVO.getCols().get(k);
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

  @Override
  public void outPrintSql(ReqExcelVO reqExcelVO) {
    List<List<String>> readExcel = convertExcelDate(reqExcelVO);
    Iterator<List<String>> iterator = readExcel.iterator();
    while (iterator.hasNext()) {
      List<java.lang.String> list = iterator.next();
       //获取每行的数据,然后输出
       String[] argumentArray = (String[])list.toArray(new String[readExcel.size()]);  
       outPrintSql(reqExcelVO.getSqlTemplate(),argumentArray );
    }
  }
}
