package cn.wbnull.hellotlj.mybatis;

import cn.wbnull.hellotlj.util.StringUtils;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Mybatis Plus 代码生成器
 *
 * @author dukunbiao(null)  2020-02-05
 * https://github.com/dkbnull/HelloTljServer
 */
public class CodeGenerator {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/hellotlj?characterEncoding=utf8&serverTimezone=GMT%2B8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

    private static final String PACKAGE_PATH = System.getProperty("user.dir") + "/src/main/java";
    private static final String RESOURCES_MAPPER_PATH = System.getProperty("user.dir") + "/src/main/resources/mapper/";

    public static void main(String[] args) {
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig());
        autoGenerator.setDataSource(dataSourceConfig());
        autoGenerator.setStrategy(strategyConfig());
        autoGenerator.setPackageInfo(packageConfig());
        autoGenerator.setCfg(injectionConfig());
        autoGenerator.setTemplate(templateConfig());
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());

        autoGenerator.execute();
    }

    private static GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(PACKAGE_PATH);
        globalConfig.setActiveRecord(true);
        globalConfig.setEnableCache(false);
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        globalConfig.setOpen(false);
        globalConfig.setAuthor("dukunbiao(null)");

        return globalConfig;
    }

    private static DataSourceConfig dataSourceConfig() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl(URL);
        dataSourceConfig.setDriverName(DRIVER_CLASS_NAME);
        dataSourceConfig.setUsername(USERNAME);
        dataSourceConfig.setPassword(PASSWORD);

        return dataSourceConfig;
    }

    private static PackageConfig packageConfig() {
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName("");
        packageConfig.setParent("cn.wbnull.hellotlj");

        return packageConfig;
    }

    private static TemplateConfig templateConfig() {
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        templateConfig.setController(null);
        templateConfig.setService(null);
        templateConfig.setServiceImpl(null);

        return templateConfig;
    }

    private static InjectionConfig injectionConfig() {
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };

        List<FileOutConfig> fileOutConfigs = new ArrayList<>();
        fileOutConfigs.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return RESOURCES_MAPPER_PATH + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        injectionConfig.setFileOutConfigList(fileOutConfigs);

        return injectionConfig;
    }

    private static StrategyConfig strategyConfig() {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setTablePrefix(packageConfig().getModuleName() + "_");
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
//        strategyConfig.setSuperEntityColumns("id");
//        strategyConfig.setTableFillList()
//        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategyConfig.setSuperEntityClass(null);
//        strategyConfig.setSuperServiceClass(null);
//        strategyConfig.setSuperServiceImplClass(null);
//        strategyConfig.setSuperMapperClass(null);
//        strategyConfig.setEntityLombokModel(true);
//        strategyConfig.setRestControllerStyle(true);
//        strategyConfig.setSuperControllerClass(null);
//        strategyConfig.setSuperEntityColumns("id");
//        strategyConfig.setControllerMappingHyphenStyle(true);
        strategyConfig.setInclude(scanner("表名，多个英文逗号分割").split(","));

        return strategyConfig;
    }

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        String hint = "请输入" + tip + "：";
        System.out.println(hint);
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (!StringUtils.isEmpty(ipt)) {
                return ipt;
            }
        }

        throw new MybatisPlusException("请输入正确的" + tip);
    }
}
