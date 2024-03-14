package com.tlaxcala.securesapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tlaxcala.securesapp.clients.ConsultsClient;
import com.tlaxcala.securesapp.dto.Consult;
import com.tlaxcala.securesapp.dto.ConsultListExam;
import com.tlaxcala.securesapp.service.ConsultService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/consults")
class Controller {

    @Autowired
    ConsultsClient consultsClient;

    @Autowired
    ConsultService consultService;

    @GetMapping
    public List<Consult> consuList(){
        log.info("----- Consumiendo el servicio externo Consuts -----");
        log.info("----- Recuperando lista Consuts -----");
        List<Consult> consults = consultsClient.getAll();
        return consults;
    }

    @PostMapping
    public ResponseEntity<Consult> consultSave(@RequestBody ConsultListExam body){
        log.info("----- Ingresando informacion en servicio de Consults Directo-----");
        log.info("Imprimiendo Objeto de la Peticion " + body);
        Consult saveConsults = consultsClient.saveConsult(body);
        return new ResponseEntity<>(saveConsults, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consult> findById(@PathVariable("id") Integer id) {
        log.info("----- Consumiendo el servicio externo Consuts -----");
        log.info("----- Recuperando Consults por Id-----");
        Consult consultById = consultsClient.getById(id);

        if (consultById != null) {
            log.info("----- Registro encontrados, validano existencia ----- ");
           
            consultService.insertConsult(consultById);
            log.info("----- Registro insertado -----");
            
        }
        
        return new ResponseEntity<>(consultById, HttpStatus.OK);
    }

    @PostMapping("/insert-f")
    public ResponseEntity<String> insertConsult(@RequestBody Consult consult) {
        consultService.insertConsult(consult);
        return ResponseEntity.ok("Consult insertada satisfactoriamente");
    }


}