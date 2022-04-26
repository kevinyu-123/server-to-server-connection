package com.travel.app.login.service;

import com.travel.app.login.dto.ResponseDto;
import com.travel.app.login.dto.TestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;

@Service
public class RestTService {

    public ResponseDto sendMessage(){

        URI uri = UriComponentsBuilder
                .fromUriString("http://127.0.0.1:8085")
                .path("/shop/message")
                .encode(Charset.defaultCharset())
                .queryParam("message","login-server")
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate template = new RestTemplate();
        ResponseEntity<ResponseDto> result = template.getForEntity(uri,ResponseDto.class);
        System.out.println(result.getBody());
        return result.getBody();
    }

}
