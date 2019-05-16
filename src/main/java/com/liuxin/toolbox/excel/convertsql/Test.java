package com.liuxin.toolbox.excel.convertsql;

import java.util.ArrayList;
import java.util.List;

import com.liuxin.toolbox.excel.convertsql.bean.ReqExcelVO;
import com.liuxin.toolbox.excel.convertsql.factory.ReadExcelToSqlFactory;
import com.liuxin.toolbox.excel.convertsql.factory.impl.ReadExcelToSql;

public class Test {
  public static void main(String[] args) {
    test1();
  }

  private static void test1() {
    ReadExcelToSqlFactory factory = new ReadExcelToSqlFactory();
    ReadExcelToSql readExcelToSql = factory.readExcel(ReadExcelToSqlFactory.TYPE_ONE);
    ReqExcelVO reqExcelVO = new ReqExcelVO();
    reqExcelVO.setFilePath("C:\\Users\\liuxin79\\Desktop\\222222.xlsx");
    reqExcelVO.setSqlTemplate("insert into demo values({},{},{})");
    List<Integer> cols = new ArrayList<>();
    cols.add(1);
    cols.add(3);
    cols.add(5);
    reqExcelVO.setCols(cols);
    readExcelToSql.outPrintSql(reqExcelVO);
  }
}
