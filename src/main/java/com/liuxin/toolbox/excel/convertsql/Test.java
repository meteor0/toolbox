package com.liuxin.toolbox.excel.convertsql;

import java.util.ArrayList;
import java.util.List;

import com.liuxin.toolbox.excel.convertsql.bean.ReqReadExceToDatalVO;
import com.liuxin.toolbox.excel.convertsql.factory.ReadExcelToSqlFactory;
import com.liuxin.toolbox.excel.convertsql.factory.ReadExcelToSqlUtil;
import com.liuxin.toolbox.excel.convertsql.service.ReadExcelToSqlService;

public class Test {
  public static void main(String[] args) {
    test1();
  }
  
  private static void test1() {
    ReadExcelToSqlFactory factory = new ReadExcelToSqlFactory();
    ReadExcelToSqlService readExcel = factory.readExcel(ReadExcelToSqlFactory.TYPE_ONE);
    ReqReadExceToDatalVO reqReadExceToDatalVO = new ReqReadExceToDatalVO();
    reqReadExceToDatalVO.setFilePath("C:\\Users\\liuxin79\\Desktop\\44444.xlsx");
    List<Integer> cols = new ArrayList<>();
    cols.add(0);
    cols.add(3);
    reqReadExceToDatalVO.setCols(cols);
    List<List<String>> convertExcelToDate = ReadExcelToSqlUtil.convertExcelToDate(reqReadExceToDatalVO);
    readExcel.outPrintSql(convertExcelToDate);
  }
}
