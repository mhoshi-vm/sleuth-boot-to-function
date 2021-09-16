package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;



@SpringBootApplication
public class Demo7Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo7Application.class, args);
    }

}

@RestController
class RestExec{

    private static final Logger LOGGER = LoggerFactory.getLogger(RestExec.class);

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    @GetMapping
    public String Rest(@RequestHeader Map<String, String> header) {
        printAllHeaders(header);

        String[] urls = { "http://localhost:8080/containsCloud" };

        for( String url : urls )
        {
            LOGGER.info(String.format("URLS = %s", url));
            restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();
        }
        return "REST Complete";
    }

    private void printAllHeaders(Map<String, String> headers) {
        headers.forEach((key, value) -> {
            LOGGER.info(String.format("Header '%s' = %s", key, value));
        });
    }
}