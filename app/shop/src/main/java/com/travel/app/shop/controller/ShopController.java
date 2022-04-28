package com.travel.app.shop.controller;

import com.travel.app.shop.dto.Message;
import com.travel.app.shop.dto.StatusType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

    @GetMapping("")
    public String test(){
        return "shop server";
    }

    @GetMapping("/message")
    public Message getMessage(@RequestParam String message){
        Message res = new Message();
        if(message.equals("login-server")){
            res.setStatus(StatusType.OK);
            res.setMessage("성공");
        }else{
            res.setStatus(StatusType.BAD_REQUEST);
            res.setMessage("실패");
        }
        return res;
    }
}

