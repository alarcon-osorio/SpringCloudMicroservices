package com.tlaxcala.securesapp.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tlaxcala.securesapp.dto.ConsultDetail;
import com.tlaxcala.securesapp.dto.Medic;
import com.tlaxcala.securesapp.dto.Patient;
import com.tlaxcala.securesapp.dto.Specialty;

import lombok.Data;

@Data
@Document(collection = "consults")
public class ConsultEntity {
    @Id
    private Integer idConsult;
    private Patient patient;
    private Medic medic;
    private Specialty specialty;
    private String numConsult;
    private LocalDateTime consultDate;
    private List<ConsultDetail> details;
}
