<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<#macro mapperEl value val>${r"#{"}${value},jdbcType=${val}}</#macro>


<mapper namespace="${packageName}.${className}Dao">
<resultMap id="${className?uncap_first}ResultMap" type="${packageName}.${className}PO">  
    <#list attrs as attr> 
          <result property="${attr.javaName}" column="${attr.dbName}" />  
      </#list>  
</resultMap>  


<sql id="sql_column">
	  <#list attrs as attr> ${attr.dbName},  <#if !attr_has_next>${attr.dbName}</#if></#list> 
</sql>

<insert id="insert${className}" parameterType="${packageName}.${className}">
	insert into ${tableName}
    <trim prefix="(" suffix=")" suffixOverrides="," >
    <#list attrs as attr> 
      <if test="${attr.javaName} != null" >
        ${attr.dbName},
      </if>
    </#list>
    </trim>
    <trim prefix="values (" suffix=")" suffixOverrides="," >
    <#list attrs as attr> 
      <if test="${attr.javaName} != null" >
           <@mapperEl attr.javaName attr.jdbcType/>,
      </if>
    </#list>
    </trim>
</insert>
	
<update id="update${className}" parameterType="${packageName}.${className}">
	update  ${tableName} set
    <trim prefix="(" suffix=")" suffixOverrides="," >
    <#list attrs as attr> 
      <if test="${attr.javaName} != null" >
        ${attr.dbName},
      </if>
    </#list>
    </trim>
    <trim prefix="values (" suffix=")" suffixOverrides="," >
    <#list attrs as attr> 
      <if test="${attr.javaName} != null" >
              <@mapperEl attr.javaName attr.jdbcType/>,
      </if>
    </#list>
    </trim>
	
</update>
	
<select id="find${className}" resultType="${packageName}.${className}">
	select 
		<include refid="sql_column"></include>
	from ${tableName}  where 1=1
	 <#list attrs as attr> 
	  <if test="${attr.javaName} != null" >
	    and  <@mapperEl attr.javaName attr.jdbcType/>,
	  </if>
    </#list>
</select>
	
		
<select id="select${className}" resultType="${packageName}.${className}">
	select 
		<include refid="sql_column"></include>
	from ${tableName}  where 1=1
	 <#list attrs as attr> 
	  <if test="${attr.javaName} != null" >
	    and  <@mapperEl attr.javaName attr.jdbcType/>,
	  </if>
    </#list>
</select>
	
	
</mapper>
