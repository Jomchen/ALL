package com.jomchen.test.utils;

/**
 * create by Jomchen on 12/30/18
 */
public class RequestObject<T> {

    private String requestId;
    private T data;

    public static <T> RequestObject<T> build(String requestId) {
        RequestObject requestObject = new RequestObject();
        requestObject.requestId = requestId;
        return requestObject;
    }

    public static <T> RequestObject<T> build(String requestId, T data) {
        RequestObject requestObject = new RequestObject();
        requestObject.requestId = requestId;
        requestObject.data = data;
        return requestObject;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
