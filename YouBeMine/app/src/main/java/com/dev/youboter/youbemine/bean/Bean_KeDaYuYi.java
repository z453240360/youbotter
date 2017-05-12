package com.dev.youboter.youbemine.bean;

/**
 * Created by zhengdongdong on 2017/5/9.
 */

public class Bean_KeDaYuYi {


    /**
     * rc : 0
     * operation : ANSWER
     * service : openQA
     * answer : {"type":"T","text":"这么容易就对我满足啦，我能更好哦~"}
     * text : 你最最好了
     */

    private int rc;
    private String operation;
    private String service;
    private AnswerBean answer;
    private String text;

    public int getRc() {
        return rc;
    }

    public void setRc(int rc) {
        this.rc = rc;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public AnswerBean getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerBean answer) {
        this.answer = answer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static class AnswerBean {
        /**
         * type : T
         * text : 这么容易就对我满足啦，我能更好哦~
         */

        private String type;
        private String text;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
