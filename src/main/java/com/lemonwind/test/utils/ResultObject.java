package com.lemonwind.test.utils;

/**
 * create by lemonwind on 12/30/18
 */
public class ResultObject<T> {

    public static final int SUCCESS_CODE = 0;
    public static final String SUCCESS_MESSAGE = "success";
    public static final int FAIL_CODE = 1;
    public static final String FAIL_MESSAGE = "fail";

    private String requestId;
    private int code;
    private String message;
    private T data;


    public static <T> ResultObject<T> buildSuccess(String requestId, T data) {
        ResultObject<T> resultObject = new ResultObject<>();
        resultObject.setRequestId(requestId);
        resultObject.setCode(ResultObject.SUCCESS_CODE);
        resultObject.setMessage(ResultObject.SUCCESS_MESSAGE);
        resultObject.setData(data);
        return resultObject;
    }
    public static <T> ResultObject<T> buildSuccess(String requestId) {
        ResultObject<T> resultObject = new ResultObject<>();
        resultObject.setRequestId(requestId);
        resultObject.setCode(ResultObject.SUCCESS_CODE);
        resultObject.setMessage(ResultObject.SUCCESS_MESSAGE);
        return resultObject;
    }

    public static <T> ResultObject<T> buildFail(String requestId) {
        ResultObject<T> resultObject = new ResultObject<>();
        resultObject.setRequestId(requestId);
        resultObject.setCode(ResultObject.FAIL_CODE);
        resultObject.setMessage(ResultObject.FAIL_MESSAGE);
        return resultObject;
    }

    public static <T> ResultObject<T> buildFail(String requestId, String msg) {
        ResultObject<T> resultObject = new ResultObject<>();
        resultObject.setRequestId(requestId);
        resultObject.setCode(ResultObject.FAIL_CODE);
        resultObject.setMessage(msg);
        return resultObject;
    }

    public <T> ResultObject<T> buildFail(String requestId, CodeEnum codeEnum) {
        ResultObject<T> resultObject = new ResultObject<>();
        resultObject.setRequestId(requestId);
        resultObject.setCode(codeEnum.getCode());
        resultObject.setMessage(codeEnum.getMessage());
        return resultObject;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
