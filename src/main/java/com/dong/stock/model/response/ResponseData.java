package com.dong.stock.model.response;

import java.util.List;

public class ResponseData<T> {
    public static final int SUCCESS = 0;

    /**
     * code : 0
     * message : success
     * data : [{"stockCode":"600004","market":"a","ipoDate":"2003-04-27T16:00:00.000Z","areaCode":"cn","name":"白云机场","fsType":"non_financial"},{"stockCode":"600006","market":"a","ipoDate":"1999-07-26T16:00:00.000Z","areaCode":"cn","name":"东风汽车","fsType":"non_financial"}]
     */

    private int code;
    private String message;
    /**
     * stockCode : 600004
     * market : a
     * ipoDate : 2003-04-27T16:00:00.000Z
     * areaCode : cn
     * name : 白云机场
     * fsType : non_financial
     */

    private T data;

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
