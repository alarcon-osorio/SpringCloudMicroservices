package com.tlaxcala.securesapp.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.tlaxcala.securesapp.dto.Exams;

@FeignClient(name="exams", url="http://localhost:8080")
public interface ExamsClient {
    
    @GetMapping("/exams")
    List<Exams> getExams();

}
