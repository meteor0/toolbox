package com.liuxin.toolbox.excel.convertsql.factory;

import com.liuxin.toolbox.excel.convertsql.factory.impl.DemoExcel;
import com.liuxin.toolbox.excel.convertsql.factory.impl.ReadExcelToSql;

public class ReadExcelToSqlFactory {

  public static final String TYPE_ONE = "demo1";// demo1


  public ReadExcelToSql readExcel(String type) {
    switch (type) {
      case TYPE_ONE:
        return new DemoExcel();
      default:
        return new DemoExcel();
    }
  }
}
