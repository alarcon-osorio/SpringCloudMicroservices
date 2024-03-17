package com.tlaxcala.securesapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tlaxcala.securesapp.clients.ExamsClient;
import com.tlaxcala.securesapp.dto.Exams;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/exams")
@Slf4j
public class ExamsController {

    @Autowired
    ExamsClient examsClient;

    @GetMapping
    public List<Exams> examsList(){
        log.info("----- Consumiendo el servicio externo exams -----");
        log.info("----- Recuperando lista Exames -----");
        List<Exams> exams = examsClient.getExams();
        return exams;
    }
    
}
