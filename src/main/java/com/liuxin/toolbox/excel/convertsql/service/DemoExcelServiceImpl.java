package com.liuxin.toolbox.excel.convertsql.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liuxin.toolbox.excel.convertsql.bean.ReqDataToPrintSqlVO;
import com.liuxin.toolbox.excel.convertsql.factory.ReadExcelToSqlUtil;

/**
 * 
 * @Description: TODO
 * @author liuxin
 * @date 2019年5月17日 下午5:05:19
 *
 */
public class DemoExcelServiceImpl implements ReadExcelToSqlService {


  Logger logger = LoggerFactory.getLogger(getClass());

  @Override
  public void outPrintSql(List<List<String>> list) {
    //归类数据.按照校区归类
    Map<String, String> map = new HashMap<String, String>();

    Iterator<List<String>> iterator = list.iterator();
    while (iterator.hasNext()) {
      List<String> next = iterator.next();
      String schoolid = next.get(0);
      String roomCode = next.get(1);
      String value = null;
      if(StringUtils.isBlank(map.get(schoolid))) {
        value = "'"+roomCode+"'";
      }else {
        value =  map.get(schoolid)+",'"+roomCode+"'";
      }
      
      map.put(schoolid, value);
    }
    
    for (String key : map.keySet()) {
    String value= map.get(key);
    List<ReqDataToPrintSqlVO> reqSqlList = new ArrayList<>();
    ReqDataToPrintSqlVO reqDataToPrintSqlVO1 = new ReqDataToPrintSqlVO();
    String sql1 = "set @scode_{} = (SELECT group_concat(t.sCode) FROM s_dept t WHERE t.nSchoolId = {} AND t.bValid = 1 AND t.nAudit = 1 AND t.enabled = TRUE AND t.display = TRUE AND t.sFCode IS NOT NULL)";
    reqDataToPrintSqlVO1.setSqlTemplate(sql1);
    List<String> param = new LinkedList<>();
    param.add(key);
    param.add(key);
    reqDataToPrintSqlVO1.setSqlValues(param);
    
    ReqDataToPrintSqlVO reqDataToPrintSqlVO2 = new ReqDataToPrintSqlVO();
    String sql2 = "set @sname_{} = (SELECT group_concat(t.sname) FROM s_dept t WHERE t.nSchoolId = {} AND t.bValid = 1 AND t.nAudit = 1 AND t.enabled = TRUE AND t.display = TRUE AND t.sFCode IS NOT NULL)";
    reqDataToPrintSqlVO2.setSqlTemplate(sql2);
    reqDataToPrintSqlVO2.setSqlValues(param);


    
    ReqDataToPrintSqlVO reqDataToPrintSqlVO3 = new ReqDataToPrintSqlVO();
    String sql3 = "update  bs_room set idleCostDept = @scode_{} ,idleCostDeptNames = @sname_{} where scode in({}) and nSchoolId={}";
    reqDataToPrintSqlVO3.setSqlTemplate(sql3);
    param.add(value);
    param.add(key);
    reqDataToPrintSqlVO3.setSqlValues(param);

    
    reqSqlList.add(reqDataToPrintSqlVO1);
    reqSqlList.add(reqDataToPrintSqlVO2);
    reqSqlList.add(reqDataToPrintSqlVO3);
    ReadExcelToSqlUtil.outPrintSql(reqSqlList);
    }
  }
}
