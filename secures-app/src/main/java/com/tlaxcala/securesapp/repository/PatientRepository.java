package com.tlaxcala.securesapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tlaxcala.securesapp.entity.PatientEntity;

public interface PatientRepository extends MongoRepository<PatientEntity, String> {

    @Query("{'idPatient' : ?0}")
    String findByIdPatient(String idPatient);
    
}
