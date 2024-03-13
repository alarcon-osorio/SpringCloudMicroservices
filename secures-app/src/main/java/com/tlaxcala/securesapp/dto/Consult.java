package com.tlaxcala.securesapp.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class Consult {

    private Integer idConsult;
    private Patient patient;  
    private Medic medic;
    private Specialty specialty;
    private String numConsult;
    private LocalDateTime consultDate;
    private List<ConsultDetailDTO> details;

}
