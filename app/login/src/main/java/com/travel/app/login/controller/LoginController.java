package com.travel.app.login.controller;

import com.travel.app.login.dto.Message;

import com.travel.app.login.service.RestTService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class LoginController {

    private final RestTService service;

    public LoginController(RestTService service){
        this.service = service;
    }

    @GetMapping("")
    public String test(){
        return "login server";
    }

    //to shop-server
    @GetMapping ("/message")
    public Message sendMessage( ){
        return service.sendMessage();
    }

    //to client
    @GetMapping("/account")
    public ResponseEntity<Message> accountInfo(@RequestParam int userNo){
        return service.accountInfo(userNo);
    }









}
