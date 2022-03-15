package com.huizekb.bierlijst.bierlijst.configuration;


import org.springframework.beans.factory.annotation.Value;

public class AwsConfig {

    @Value("${accesskey}")
    private String accessKey;


    @Value("${secretKey}")
    private String secretKey;

    @Value("${region}")
    private String region;

    @Value("${endpoint}")
    private String endpoint;

}
