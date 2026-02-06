package com.example.roletest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class ConfigAws {

    @Bean
    public S3Client s3Client() {
        return S3Client.builder()
                .region(Region.AWS_GLOBAL) // IAM é global
                .build();
    }
}