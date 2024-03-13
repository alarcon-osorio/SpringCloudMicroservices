package com.tlaxcala.securesapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tlaxcala.securesapp.clients.ConsultsClient;
import com.tlaxcala.securesapp.dto.Consult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
class Controller {

    @Autowired
    ConsultsClient consultsClient;

    @GetMapping("/consults")
    public List<Consult> consuList(){
        log.info("----- Ingresando a consumir el servicio de Consuts -----");
        List<Consult> consults = consultsClient.getAll();
        return consults;
    }
    
}