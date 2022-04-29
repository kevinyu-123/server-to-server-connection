package com.travel.app.login.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Message {

    private StatusType status;
    private String message;
    private long responseTime;
    private AccountDto data;


    public Message() {

        this.status = StatusType.NOT_FOUND;
        this.message = null;
        this.data = null;
        this.responseTime = 0;
    }
}
