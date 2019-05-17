package com.liuxin.toolbox.excel.convertsql.factory;

import com.liuxin.toolbox.excel.convertsql.service.DemoExcelServiceImpl;
import com.liuxin.toolbox.excel.convertsql.service.ReadExcelToSqlService;

public class ReadExcelToSqlFactory {

  public static final String TYPE_ONE = "demo1";// demo1


  public ReadExcelToSqlService readExcel(String type) {
    switch (type) {
      case TYPE_ONE:
        return new DemoExcelServiceImpl();
      default:
        return new DemoExcelServiceImpl();
    }
  }
}
