package com.example.demoAPI;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "com.exo.webapi")
@Data
public class CustomProperties {

    private String apiUrl;

}