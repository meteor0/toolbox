package com.liuxin.toolbox.excel.convertsql.bean;

import java.io.Serializable;
import java.util.List;

public class ReqExcelVO  implements Serializable{

  /**
   * @Fields serialVersionUID 
   */
  private static final long serialVersionUID = -1840425196962469640L;

  private String filePath;  //文件路径
  
  private List<Integer> cols; //需要读取的列
  
  private List<String> values;  //输出语句,每个index表示一个断句
  
  private String value;         //输出语句,用{}占位符号隔开

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

  public List<String> getValues() {
    return values;
  }

  public void setValues(List<String> values) {
    this.values = values;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
