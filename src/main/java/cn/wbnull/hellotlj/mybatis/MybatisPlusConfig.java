package cn.wbnull.hellotlj.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Mybatis Plus 配置类
 *
 * @author dukunbiao(null)  2020-02-05
 * https://github.com/dkbnull/HelloTljServer
 */
@Configuration
@EnableTransactionManagement
@MapperScan("cn.wbnull.hellotlj.mapper")
public class MybatisPlusConfig {

}
