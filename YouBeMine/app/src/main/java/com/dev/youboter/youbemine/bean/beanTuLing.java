package com.dev.youboter.youbemine.bean;

/**
 * Created by zhengdongdong on 2017/5/9.
 */

public class beanTuLing {

    private String code;
    private String text;


    public beanTuLing(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
