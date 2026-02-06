package com.example.iamtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class S3Controller {

    @Autowired
    S3Service s3Service;

    @GetMapping("/s3/files")
    public ResponseEntity<List<String>> listarArquivos(@RequestParam String bucket) {

        List<String> nomesDosFiles =  s3Service.listFiles(ListObjectsV2Request.builder().bucket(bucket).build());
        return  ResponseEntity.ok(nomesDosFiles);


    }

}