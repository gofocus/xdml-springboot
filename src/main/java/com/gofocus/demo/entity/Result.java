package com.gofocus.demo.entity;

/**
 * @Author: GoFocus
 * @Date: 2020-06-10 17:55
 * @Description:
 */
public abstract class Result<T> {
    public enum ResultStatus {
        OK("ok"),
        FAIL("fail");

        private String status;

        public String getStatus() {
            return status;
        }

        ResultStatus(String status) {
            this.status = status;
        }
    }

    private ResultStatus status;
    private String msg;
    private T data;

    protected Result(ResultStatus status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public String getStatus() {
        return status.status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

}
