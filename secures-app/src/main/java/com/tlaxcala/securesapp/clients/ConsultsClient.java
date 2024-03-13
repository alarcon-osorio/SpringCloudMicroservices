package com.tlaxcala.securesapp.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.tlaxcala.securesapp.dto.Consult;

@FeignClient(name="consults", url="http://localhost:8080")
public interface ConsultsClient {
    
    @GetMapping("/consults")
    List<Consult> getAll();

}
