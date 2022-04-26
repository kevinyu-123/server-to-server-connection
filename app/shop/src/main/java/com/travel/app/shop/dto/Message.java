package com.travel.app.shop.dto;

import lombok.Data;


@Data
public class Message {

    private StatusType status;

    public Message() {

        this.status = StatusType.NOT_FOUND;


    }

}
