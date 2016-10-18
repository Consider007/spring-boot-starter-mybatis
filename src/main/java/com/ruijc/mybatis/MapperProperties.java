package com.ruijc.mybatis;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

@ConditionalOnClass(MapperScannerConfigurer.class)
@ConfigurationProperties("mybatis.mapper")
public class MapperProperties {

    private String mappers;
    private String notEmpty;
    private String identity;

    public String getNotEmpty() {
        return notEmpty;
    }

    public void setNotEmpty(String notEmpty) {
        this.notEmpty = notEmpty;
    }

    public String getMappers() {
        return mappers;
    }

    public void setMappers(String mappers) {
        this.mappers = mappers;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
