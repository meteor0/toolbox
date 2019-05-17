package com.liuxin.toolbox.codegenerate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MBGenerator {
	public static void main(String[] args) {
		try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
          	File configFile = new File("E:/workSpace/z_code/src/com/code/mybatis/config/generatorConfig.xml");

          	ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            System.out.println("操作成功!!!");
        }catch (Exception e){
            e.printStackTrace();

        }
	}
}
