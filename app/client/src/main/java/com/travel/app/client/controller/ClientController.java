package com.travel.app.client.controller;

import com.travel.app.client.dto.Message;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController
public class ClientController {

    @GetMapping("")
    public String test(){
        return "client";
    }

    @GetMapping("/account")
    public ResponseEntity accountInfo() {
        RestTemplate template = new RestTemplate();
        List<ResponseEntity<Message>> result = new ArrayList<>();

        for(int i=0;i<5;i++){ //시간
            long sTime = System.currentTimeMillis();
            int finalI = i;
            Thread thread = new Thread(()->{
               log.info("thread begin");
                URI uri = UriComponentsBuilder
                        .fromUriString("http://127.0.0.1:8080")
                        .path("/login/account")
                        .encode(Charset.defaultCharset())
                        .queryParam("userNo", finalI)
                        .build()
                        .toUri();

                result.add(template.getForEntity(uri, Message.class));

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("thread ["+ (finalI+1) +"] result : "+String.valueOf(result));

            });
            thread.start();
        }
        return ResponseEntity.ok().build();
    }


    @GetMapping("/shop")
    public ResponseEntity cartInfo(){
        RestTemplate template = new RestTemplate();

        return null;
    }
}
