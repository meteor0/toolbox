package ${packageName};

import java.util.List;


public interface ${className}Service {

	
    int insert${className}(${className} ${className?uncap_first} );
    
    int update${className}(${className} ${className?uncap_first} );
    
    ${className} find${className} (${className} ${className?uncap_first} );
    
    List<${className}> select${className} (${className} ${className?uncap_first} ); 
    
}