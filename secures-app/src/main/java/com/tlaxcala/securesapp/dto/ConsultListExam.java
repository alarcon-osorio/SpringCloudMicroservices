package com.tlaxcala.securesapp.dto;

import java.util.List;

import lombok.Data;

@Data
public class ConsultListExam {
    
    private Consult consult;
    private List<Exams> lstExam;

}
