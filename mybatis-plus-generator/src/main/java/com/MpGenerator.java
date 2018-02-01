package com;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yksoul
 * @version 1.0
 * @date 2018-01-27
 */
public class MpGenerator {

    /**
     * OutputDir
     */
    private static final String OUTPUT_DIR = "/home/yksoul/Code/workspace/Study/javaReview/mybatis-plus-generator/src/main/java";

    /**
     * Author
     */
    private static final String AUTHOR = "yksoul";

    /**
     * packageName
     */
    private static final String PACKAGE_NAME = "com.yksoul";

    /**
     * jdbc
     */
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    /**
     * user
     */
    private static final String JDBC_USER = "root";
    /**
     * password
     */
    private static final String JDBC_PASSWORD = "123456";
    /**
     * jdbc_url
     */
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/db_user?characterEncoding=utf8";


    public static void main(String[] args) {
        // 全局配置
        GlobalConfig gc = new GlobalConfig()
                .setOutputDir(OUTPUT_DIR)
                .setFileOverride(true)
                // 不需要ActiveRecord特性的请改为false
                .setActiveRecord(true)
                // XML 二级缓存
                .setEnableCache(false)
                // XML ResultMap
                .setBaseResultMap(true)
                // XML columList
                .setBaseColumnList(false)
                // .setKotlin(true) 是否生成 kotlin 代码
                // 自定义文件命名，注意 %s 会自动填充表实体属性！
                // .setMapperName("%sDao")
                .setAuthor(AUTHOR);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig()
                .setDbType(DbType.MYSQL)
                .setTypeConvert(new MySqlTypeConvert() {
                    // 自定义数据库表字段类型转换【可选】
                    @Override
                    public DbColumnType processTypeConvert(String fieldType) {
                        String t = fieldType.toLowerCase();
                        // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                        if (t.equals("date")) {
                            return DbColumnType.LOCAL_DATE;
                        } else if (t.equals("datetime")) {
                            return DbColumnType.LOCAL_DATE_TIME;
                        } else if (t.equals("time")) {
                            return DbColumnType.LOCAL_TIME;
                        } else if (t.equals("timestamp")) {
                            return DbColumnType.TIMESTAMP;
                        } else {
                            return super.processTypeConvert(fieldType);
                        }
                    }
                })
                .setDriverName(JDBC_DRIVER)
                .setUsername(JDBC_USER)
                .setPassword(JDBC_PASSWORD)
                .setUrl(JDBC_URL);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig()
                // .setCapitalMode(true);// 全局大写命名 ORACLE 注意
                // .setTablePrefix(new String[]{"tlog_", "tsys_"}) // 此处可以修改为您的表前缀
                // .setInclude(new String[] { "user" }) // 需要生成的表
                // .setExclude(new String[]{"test"}) // 排除生成的表
                // 自定义实体父类
                 .setSuperEntityClass(PACKAGE_NAME + ".entity.BaseEntity")
                // 自定义实体，公共字段
                .setSuperEntityColumns(new String[] { "id"})
                // 自定义 mapper 父类
                // .setSuperMapperClass("com.baomidou.demo.TestMapper")
                // 自定义 service 父类
                // .setSuperServiceClass("com.baomidou.demo.TestService")
                // 自定义 service 实现类父类
                // .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")
                // 自定义 controller 父类
                // .setSuperControllerClass("com.baomidou.demo.TestController")
                // 【实体】是否生成字段常量（默认 false）
                // public static final String ID = "test_id";
                // .setEntityColumnConstant(true)
                // 【实体】是否为构建者模型（默认 false）
                // public User setName(String name) {this.name = name; return this;}
                // .setEntityBuilderModel(true)
                // 表名生成策略
                .setEntityLombokModel(true)
                .setNaming(NamingStrategy.underline_to_camel);

        PackageConfig pc = new PackageConfig()
                .setParent(PACKAGE_NAME)
                .setController("controller");

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("author", AUTHOR);
                map.put("version", "1.0");
                this.setMap(map);
            }
        };

        List<FileOutConfig> focList = new ArrayList<>();
        // 调整 xml 生成目录演示
        /*focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "src/main/resources/mapper/" + tableInfo.getEntityName() + ".xml";
            }
        });*/
        cfg.setFileOutConfigList(focList);

        // 关闭默认 xml 生成，调整生成 至 根目录
        TemplateConfig tc = new TemplateConfig()
                .setController(null)
                .setXml(null);

        // 执行生成
        new AutoGenerator()
                .setGlobalConfig(gc)
                .setDataSource(dsc)
                .setStrategy(strategy)
                .setPackageInfo(pc)
                .setCfg(cfg)
                .setTemplate(tc)
                .execute();
    }


}
