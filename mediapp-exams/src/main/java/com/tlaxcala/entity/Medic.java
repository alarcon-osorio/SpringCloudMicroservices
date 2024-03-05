package com.tlaxcala.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Medic {
   
    private Integer idMedic;
    private String primaryName;
    private String surname;
    private String codMedic;
    private String photo;
    
}
