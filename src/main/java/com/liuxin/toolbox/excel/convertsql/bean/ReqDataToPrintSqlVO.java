package com.liuxin.toolbox.excel.convertsql.bean;

import java.io.Serializable;
import java.util.List;

public class ReqDataToPrintSqlVO  implements Serializable{

  /**
   * @Fields serialVersionUID 
   */
  private static final long serialVersionUID = -1840425196962469640L;

  //输出语句,需要替换的值用{}占位符号代替
  private String  sqlTemplate;      

  //sqlTemplate中每个{}的值
  private List<String> sqlValues;   

  public String getSqlTemplate() {
    return sqlTemplate;
  }

  public void setSqlTemplate(String sqlTemplate) {
    this.sqlTemplate = sqlTemplate;
  }

  public List<String> getSqlValues() {
    return sqlValues;
  }

  public void setSqlValues(List<String> sqlValues) {
    this.sqlValues = sqlValues;
  }
}
