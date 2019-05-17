package ${packageName};

import java.io.Serializable;


public class ${className}  implements Serializable {

	private static final long serialVersionUID = 1L;

    <#list attrs as attr> 
    private ${attr.javaType} ${attr.javaName};
    </#list>

    <#list attrs as attr>
    public void set${attr.javaName?cap_first}(${attr.javaType} ${attr.javaName}){
        this.${attr.javaName} = ${attr.javaName};
    }
    public ${attr.javaType} get${attr.javaName?cap_first}(){
        return this.${attr.javaName};
    }

    </#list>
}