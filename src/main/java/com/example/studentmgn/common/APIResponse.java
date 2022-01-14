package com.example.studentmgn.common;

public class APIResponse {
    private int code;

    private String messCode;

    private Object result;

    public APIResponse(int code, String messCode, Object result) {
        this.code = code;
        this.messCode = messCode;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessCode() {
        return messCode;
    }

    public void setMessCode(String messCode) {
        this.messCode = messCode;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public static APIResponse buildResponse(Message message, Object result) {
        return new APIResponse(message.getCode(), message.getMess(), result);
    }

    public static APIResponse buildResponse(Message message) {
        return new APIResponse(message.getCode(), message.getMess(), null);
    }
}
