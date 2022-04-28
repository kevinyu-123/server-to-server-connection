package com.travel.app.login.service;

import com.travel.app.login.dto.ResponseDto;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;

@Slf4j
@Service
public class RestTService {

    public ResponseDto<String> sendMessage(){
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
            ResponseEntity<ResponseDto> result = restTemplate.getForEntity(uri, ResponseDto.class);

            long eTime = System.currentTimeMillis();

            log.info((eTime - sTime) / 1000.0 + "sec");


            return result.getBody();
    }


}
