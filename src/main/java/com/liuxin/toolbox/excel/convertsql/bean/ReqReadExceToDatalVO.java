package com.liuxin.toolbox.excel.convertsql.bean;

import java.io.Serializable;
import java.util.List;

public class ReqReadExceToDatalVO implements Serializable {

  /**
   * @Fields serialVersionUID
   */
  private static final long serialVersionUID = -1840425196962469640L;

  private String filePath; // 文件路径

  private List<Integer> cols; //需要读取的数据行

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
}
