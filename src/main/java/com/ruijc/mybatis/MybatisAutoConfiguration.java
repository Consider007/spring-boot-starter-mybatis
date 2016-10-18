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
    @ConditionalOnClass(PageHelper.class)
    public PageHelper pageHelper(DataSource dataSource) {
        PageHelper pageHelper = new PageHelper();

        Properties properties = new Properties();
        if (null != helperProperties) {
            properties.setProperty("dialect", helperProperties.getDialect());
            properties.setProperty("offsetAsPageNum", helperProperties.getOffsetAsPageNum());
            properties.setProperty("rowBoundsWithCount", helperProperties.getRowBoundsWithCount());
            properties.setProperty("pageSizeZero", helperProperties.getPageSizeZero());
            properties.setProperty("reasonable", helperProperties.getReasonable());
            properties.setProperty("params", helperProperties.getParams());
            properties.setProperty("supportMethodsArguments", helperProperties.getSupportMethodsArguments());
            properties.setProperty("returnPageInfo", helperProperties.getReturnPageInfo());
            properties.setProperty("closeConn", helperProperties.getCloseConn());
        }
        pageHelper.setProperties(properties);

        return pageHelper;
    }

    @Bean
    @ConditionalOnClass(MapperScannerConfigurer.class)
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();

        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.isea533.mybatis.mapper");
        Properties properties = new Properties();
        if (null != mapperProperties) {
            properties.setProperty("mappers", mapperProperties.getMappers());
            properties.setProperty("notEmpty", mapperProperties.getNotEmpty());
            properties.setProperty("IDENTITY", mapperProperties.getIdentity());
            properties.setProperty("ORDER", mapperProperties.getOrder());
            properties.setProperty("catalog", mapperProperties.getCatalog());
            properties.setProperty("schema", mapperProperties.getSchema());
            properties.setProperty("seqFormat", mapperProperties.getSeqFormat());
            properties.setProperty("style", mapperProperties.getStyle());
            properties.setProperty("enableMethodAnnotation", mapperProperties.getEnableMethodAnnotation());
        }
        mapperScannerConfigurer.setProperties(properties);

        return mapperScannerConfigurer;
    }
}
