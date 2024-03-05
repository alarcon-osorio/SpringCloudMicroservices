package com.tlaxcala.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tlaxcala.entity.Medic;

@Component
@FeignClient(name = "mediapp-medics" , url = "http://localhost:8080/medics")
@RequestMapping("/medic")
public interface MedicsClient {

    @GetMapping("/{id}")
    public Medic findById(@PathVariable("id") Integer id);
    
}
