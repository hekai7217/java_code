package com.jutixueyuan.test;

import org.apache.ibatis.io.Resources;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 黄药师
 * @date 2020-10-13 16:47
 * @desc 百战程序员 http://www.jutixueyuan.com
 */
public class AppTest {

    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //指定 逆向工程配置文件
        Reader reader = Resources.getResourceAsReader("generatorConfig.xml");

        // config的姐你是去
        ConfigurationParser cp = new ConfigurationParser(warnings);
        // 拿到config
        Configuration config = cp.parseConfiguration(reader);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);

        // 自动映射器 (根据 数据的表自动生成 pojo类,mapper接口和mapper.xml)
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);
    }
}
