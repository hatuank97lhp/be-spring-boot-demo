package com.example.studentmgn.common;

public enum Message {
    API_SUCCESS(101, "api.success"),
    CLASS_ID_NOT_FOUND(201, "api.class.id-not-found");

    private int code;

    private String mess;

    public int getCode() {
        return code;
    }

    public String getMess() {
        return mess;
    }

    Message(int code, String mess) {
        this.code = code;
        this.mess = mess;
    }
}
