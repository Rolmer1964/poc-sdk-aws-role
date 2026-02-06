package com.example.roletest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import software.amazon.awssdk.services.s3.model.S3Object;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class S3Service {

    @Autowired
    S3Client s3Client;

    public List<String> listFiles(ListObjectsV2Request request) {
        ListObjectsV2Response response = s3Client.listObjectsV2(request);
        List<String> nomesDosFiles = response
                .contents()
                .stream()
                .map(S3Object::key)
                .collect(Collectors.toList());;

        return nomesDosFiles;

    }

}
