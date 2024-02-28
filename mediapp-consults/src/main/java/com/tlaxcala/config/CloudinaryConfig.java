package com.tlaxcala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudinaryConfig {
    
    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "xxxx", // valores de las crendenciales de la cuenta
            "api_key", "xxxx",
            "api_secret", "xxxx"
        ));
    }
}
