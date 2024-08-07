package com.narainox.ecommercebackendapplication.exception;

public class RecordNotFoundException extends RuntimeException {
    private String record;
    private String type;
    private Object value;

    public RecordNotFoundException(String record, String type, Object value) {
        super(String.format("%s Not Found With %s : %s",record,type,value));
        this.record = record;
        this.type = type;
        this.value = value;
    }
}
