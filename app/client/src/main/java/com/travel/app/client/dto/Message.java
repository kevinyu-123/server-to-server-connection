package com.travel.app.client.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Message {

    String status;
    String message;
    Object data;
    long responseTime;
}
