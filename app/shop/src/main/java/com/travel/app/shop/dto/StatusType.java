package com.travel.app.shop.dto;

public enum StatusType {

    OK(200, "OK"),
    BAD_REQUEST(400, "BAD_REQUEST"),
    NOT_FOUND(404, "NOT_FOUND"),
    INTERNAL_SERER_ERROR(500, "INTERNAL_SERVER_ERROR");

    int statusCode;
    String status;

    StatusType(int statusCode,String status){
        this.statusCode = statusCode;
        this.status = status;
    }

}
