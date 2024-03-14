package com.tlaxcala.securesapp.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tlaxcala.securesapp.dto.Consult;
import com.tlaxcala.securesapp.dto.ConsultListExam;

@FeignClient(name="consults", url="http://localhost:8080")
public interface ConsultsClient {
    
    @GetMapping("/consults")
    List<Consult> getAll();

    @GetMapping("/consults/{id}")
    Consult getById(@PathVariable("id") Integer id);

    @PostMapping("/consults")
    Consult saveConsult(@RequestBody ConsultListExam body);

}
