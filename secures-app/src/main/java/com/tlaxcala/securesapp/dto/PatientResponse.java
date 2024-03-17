package com.tlaxcala.securesapp.dto;

import java.io.Serializable;

import com.tlaxcala.securesapp.entity.PatientEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientResponse implements Serializable {

    private PatientEntity patientEntity;
    private String message;
    
}
