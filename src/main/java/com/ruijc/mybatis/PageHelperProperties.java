package com.ruijc.mybatis;

import com.github.pagehelper.PageHelper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConditionalOnClass(PageHelper.class)
@ConfigurationProperties("mybatis.pageHelper")
public class PageHelperProperties {

    private String offsetAsPageNum;
    private String rowBoundsWithCount;
    private String reasonable;

    public String getOffsetAsPageNum() {
        return offsetAsPageNum;
    }

    public void setOffsetAsPageNum(String offsetAsPageNum) {
        this.offsetAsPageNum = offsetAsPageNum;
    }

    public String getRowBoundsWithCount() {
        return rowBoundsWithCount;
    }

    public void setRowBoundsWithCount(String rowBoundsWithCount) {
        this.rowBoundsWithCount = rowBoundsWithCount;
    }

    public String getReasonable() {
        return reasonable;
    }

    public void setReasonable(String reasonable) {
        this.reasonable = reasonable;
    }
}
