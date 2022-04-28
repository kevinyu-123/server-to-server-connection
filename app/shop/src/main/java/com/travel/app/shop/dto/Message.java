package com.travel.app.shop.dto;

import lombok.Data;


@Data
public class Message {

    private StatusType status;
    private String message;

    public Message() {
        this.status = StatusType.NOT_FOUND;
        this.message = null;
    }

}
