package com.tlaxcala;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableEncryptableProperties
@EnableFeignClients
public class MediappExamsBackend {

    public static void main(String[] args) {
        SpringApplication.run(MediappExamsBackend.class, args);

    }
}
