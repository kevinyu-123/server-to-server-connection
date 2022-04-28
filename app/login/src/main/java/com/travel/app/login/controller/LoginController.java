package com.travel.app.login.controller;

import com.travel.app.login.dto.ResponseDto;

import com.travel.app.login.service.RestTService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping ("/message")
    public ResponseDto sendMessage( ){
        return service.sendMessage();

    }








}
