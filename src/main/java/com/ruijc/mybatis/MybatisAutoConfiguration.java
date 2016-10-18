package com.ruijc.mybatis;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Mybatis自动化配置
 *
 * @author Storezhang
 */
@Configuration
@AutoConfigureAfter(org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration.class)
public class MybatisAutoConfiguration {

    @Autowired
    private PageHelperProperties helperProperties;
    @Autowired
    private MapperProperties mapperProperties;

    @Bean
    //@ConditionalOnClass(PageHelper.class)
    public PageHelper pageHelper(DataSource dataSource) {
        PageHelper pageHelper = new PageHelper();

        Properties properties = new Properties();
        if (null != helperProperties) {
            properties.setProperty("offsetAsPageNum", helperProperties.getOffsetAsPageNum());
            properties.setProperty("rowBoundsWithCount", helperProperties.getRowBoundsWithCount());
            properties.setProperty("reasonable", helperProperties.getReasonable());
        }
        pageHelper.setProperties(properties);

        return pageHelper;
    }

    @Bean
    //@ConditionalOnClass(MapperScannerConfigurer.class)
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();

        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.isea533.mybatis.mapper");
        Properties properties = new Properties();
        if (null != mapperProperties) {
            properties.setProperty("mappers", mapperProperties.getMappers());
            properties.setProperty("notEmpty", mapperProperties.getNotEmpty());
            properties.setProperty("IDENTITY", mapperProperties.getIdentity());
        }
        mapperScannerConfigurer.setProperties(properties);

        return mapperScannerConfigurer;
    }
}
