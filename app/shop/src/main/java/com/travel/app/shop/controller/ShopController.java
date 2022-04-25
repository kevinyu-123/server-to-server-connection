package com.travel.app.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

    @GetMapping("")
    public String test(){
        return "shop server";
    }
}

