package com.travel.app.login.service;

import com.travel.app.login.dto.AccountDto;
import com.travel.app.login.dto.Message;
import com.travel.app.login.dto.StatusType;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;

@Slf4j
@Service
public class RestTService {

    public Message sendMessage(){
        long sTime = System.currentTimeMillis();
            URI uri = UriComponentsBuilder
                    .fromUriString("http://127.0.0.1:8085")
                    .path("/shop/message")
                    .encode(Charset.defaultCharset())
                    .queryParam("message", "login-server")
                    .build()
                    .toUri();

            log.info(uri.toString());

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Message> result = restTemplate.getForEntity(uri, Message.class);

            long eTime = System.currentTimeMillis();

            log.info((eTime - sTime) / 1000.0 + "sec");


            return result.getBody();
    }


        public ResponseEntity<Message> accountInfo(int userNo) {
            long sTime = System.currentTimeMillis();
            log.info("login-server");

            Message message = new Message();
            AccountDto dto = new AccountDto();

            dto.setDob("1999-93-93");
            dto.setName("test");
            dto.setPhoneNo(01033334444);
            dto.setUserNo(userNo);

            message.setMessage("return data");
            message.setStatus(StatusType.OK);
            message.setData(dto);

            long eTime = System.currentTimeMillis();
            message.setResponseTime(eTime - sTime);

            log.info((eTime - sTime)/1000.0+"sec");

            return new ResponseEntity<Message>(message, HttpStatus.OK);
        }






}
