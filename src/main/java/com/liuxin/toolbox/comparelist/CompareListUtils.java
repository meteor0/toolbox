package com.liuxin.toolbox.comparelist;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class CompareListUtils {

      public static List<?> compareDifferentListData(List<?> list) throws Exception {
            List<Person> newList = new ArrayList<>();
            Person beforePerson = null;
            Map<String, String> columnMap = needCompareMap();
            Iterator<?> iterator = list.iterator();
            while (iterator.hasNext()){
                  boolean flag = false;
                  Person person = (Person) iterator.next();
                  Field[] fields = person.getClass().getDeclaredFields();
                  for (Field field : fields) {
                        String fieldName= field.getName();
                        if(columnMap.containsKey(fieldName)){
                              Method method = (Method) person.getClass().getMethod("get" + getMethodName(fieldName));
                              Object value =  method.invoke(person);
                              Object beforeValue = null;
                              if(beforePerson != null){
                                    Method beforeMethod = (Method) beforePerson.getClass().getMethod("get" + getMethodName(fieldName));
                                    beforeValue =  beforeMethod.invoke(beforePerson);
                              }
                              if(!value.equals(beforeValue)){
                                    flag = true;
                                    continue;
                              }
                        }
                  }
                  if(flag){
                        newList.add(person);
                  }
                  beforePerson = person;

            }
            return newList;

      }

      public static void main(String[] args) throws Exception {
            List<Person> list = new ArrayList();
            Person person1 = new Person(1,"刘新",28,"北京市","15311320938","男1","remar1");
            Person person2 = new Person(2,"刘新",28,"北京市","15311320938","男2","remar2");
            Person person3 = new Person(3,"刘新",29,"北京市","15311320938","男3","remar3");
            Person person4 = new Person(4,"刘新",22,"北京市2","15311320938","男3","remar3");
            Person person5 = new Person(5,"刘新",29,"北京市","15311320938","男3","remar3");
            Person person6 = new Person(6,"刘新",29,"北京市","15311320938","男3","remar3");
            Person person7 = new Person(7,"刘新",29,"北京市2","15311320938","男3","remar3");
            Person person8 = new Person(8,"刘新",29,"北京市","15311320938","男3","remar3");


            list.add(person1);
            list.add(person2);
            list.add(person3);
            list.add(person4);
            list.add(person5);
            list.add(person6);
            list.add(person7);
            list.add(person8);
            List<Person> person = (List<Person>) compareDifferentListData(list);
            System.out.println(JSON.toJSONString(person));
            System.out.println(person.size());

      }

      private static Map<String,String> needCompareMap(){
            Map<String,String> param = new HashMap<>();
            param.put("name","姓名");
            param.put("age","年龄");
            param.put("address","地址");
            return param;

      }

      private static String getMethodName(String fildeName) throws Exception{
         byte[] items = fildeName.getBytes();
         items[0] = (byte) ((char) items[0] - 'a' + 'A');
         return new String(items);
      }
}
