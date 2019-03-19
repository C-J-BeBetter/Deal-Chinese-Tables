package com.chaijin.util.entity;

import java.util.List;

/**
 * @ProjectName: java
 * @Package: com.baidu.translate.demo.entity
 * @ClassName: result
 * @Description:
 * @Author: 柴进
 * @Date: 2019/3/15 16:16
 * @Version: 1.0
 */
public class Result {
    private String from;
    private String to;
    private List<TransResult> transResult;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<TransResult> getTransResult() {
        return transResult;
    }

    public void setTransResult(List<TransResult> transResult) {
        this.transResult = transResult;
    }
}
