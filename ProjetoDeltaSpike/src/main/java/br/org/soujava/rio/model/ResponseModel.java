package br.org.soujava.rio.model;

public class ResponseModel {

    private int code;
    private String message;

    public ResponseModel() {
    }

    public ResponseModel(int code, String message) {
        this.code = code;
        this.message = message;
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
}
