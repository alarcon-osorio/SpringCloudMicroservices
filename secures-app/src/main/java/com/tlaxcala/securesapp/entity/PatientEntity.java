package com.tlaxcala.securesapp.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "idPatient")
@Document(collection = "patients")
public class PatientEntity implements Serializable{

    @Id
    private String idPatient;
    private String firstName;
    private String lastName;
    private String dni;
    private String address;
    private String phone;
    private String email;
    
}
