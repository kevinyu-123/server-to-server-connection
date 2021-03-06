package com.travel.app.shop.dto;

import lombok.Data;


@Data
public class Message {

    private StatusType status;
    private String message;
    private long responseTime;
    private ShopDto data;

    public Message() {
        this.status = StatusType.NOT_FOUND;
        this.message = null;
        this.responseTime = Long.parseLong(null);
        this.data = null;
    }

}
