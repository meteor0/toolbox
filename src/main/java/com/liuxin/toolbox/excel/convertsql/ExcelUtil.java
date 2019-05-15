package com.liuxin.toolbox.excel.convertsql;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liuxin.toolbox.excel.convertsql.bean.ReqExcelVO;

public class ExcelUtil {

  Logger log = LoggerFactory.getLogger(getClass());
  
  public String readExcel(ReqExcelVO reqExcelVO) {
    
    try {
      Map<String, List<List<String>>> result = ExcelRead.readExcel("C:\\Users\\liuxin79\\Desktop\\222222.xlsx");
      Iterator<Entry<String, List<List<String>>>> iterator = result.entrySet().iterator();

      while (iterator.hasNext()) {
        Entry<String, List<List<String>>> sheet = iterator.next();
        List<List<String>> value = sheet.getValue();
        for (int i = 0; i < value.size(); i++) {
          if(i==0) {
            continue;
          }
         List<String> list= value.get(i);

         StringBuffer buffer = new StringBuffer();
         String nschoolid = list.get(1);
         nschoolid = nschoolid.substring(0, nschoolid.length()-2);
         String discard = list.get(7);
          if("是".equals(discard)) {
            
         buffer.append("update bs_area set ").append("sAreaState=4 ").append("where scode='").append(list.get(4)).append("' and nschoolId=").append(nschoolid).append(";");
         System.out.println(buffer.toString());
         System.out.println();
          }
        }
      }
    } catch (IOException e) {
      log.error("无效的文件");
    }
    return null;
  }
}
