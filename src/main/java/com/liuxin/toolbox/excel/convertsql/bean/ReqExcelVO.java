package com.liuxin.toolbox.excel.convertsql.bean;

import java.io.Serializable;
import java.util.List;

public class ReqExcelVO  implements Serializable{

  /**
   * @Fields serialVersionUID 
   */
  private static final long serialVersionUID = -1840425196962469640L;

  private String filePath;    //文件路径
  
  private List<Integer> cols; //需要读取excel的列
  
  private String sqlTemplate; //输出语句,需要替换的值用{}占位符号隔开

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public List<Integer> getCols() {
    return cols;
  }

  public void setCols(List<Integer> cols) {
    this.cols = cols;
  }

  public String getSqlTemplate() {
    return sqlTemplate;
  }

  public void setSqlTemplate(String sqlTemplate) {
    this.sqlTemplate = sqlTemplate;
  }

}
