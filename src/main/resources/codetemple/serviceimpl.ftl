package ${packageName};

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ${className}ServiceImpl implements ${className}Service{

	@Autowired
	private ${className}Dao ${className?uncap_first}Dao  ;
	
	@Override	
    public int insert${className}(${className} ${className?uncap_first} ){
    
    	return ${className?uncap_first}Dao.insert${className}(${className?uncap_first});
    }
    
    @Override
    public int update${className}(${className} ${className?uncap_first} ){
    
        return ${className?uncap_first}Dao.update${className}(${className?uncap_first});
    }
    
    @Override
    public ${className} find${className} (${className} ${className?uncap_first} ){
    
        return ${className?uncap_first}Dao.find${className}(${className?uncap_first});
    }
    
    @Override
    public List<${className}> select${className} (${className} ${className?uncap_first} ){
    
        return ${className?uncap_first}Dao.select${className}(${className?uncap_first});
    } 
    
}