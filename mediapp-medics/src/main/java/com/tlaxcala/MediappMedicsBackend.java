package com.tlaxcala;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableEncryptableProperties
public class MediappMedicsBackend {

    public static void main(String[] args) {
        SpringApplication.run(MediappMedicsBackend.class, args);

    }
}
