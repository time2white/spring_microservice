package com.me.ribbon_consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloConsumer {
    @Autowired
    RestTemplate template;

    @RequestMapping("/hello")
    public String hello(){
        ResponseEntity<String> entity = template.getForEntity("http://HELLO-PROVIDER/hello", String.class);
        System.out.println(entity.getClass());

        return entity.getBody();
    }
}
