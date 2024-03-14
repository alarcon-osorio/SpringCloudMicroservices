package com.tlaxcala.securesapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tlaxcala.securesapp.entity.ConsultEntity;

@Repository
public interface ConsultRepository extends MongoRepository<ConsultEntity, Integer> {

}
