package com.tlaxcala.securesapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.tlaxcala.securesapp.dto.Consult;

@Service
public class ConsultService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @SuppressWarnings("null")
    public void insertConsult(Consult consult) {
        mongoTemplate.insert(consult, "consults");
    }

    
}
