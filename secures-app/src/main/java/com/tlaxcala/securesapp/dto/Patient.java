package com.tlaxcala.securesapp.dto;

import lombok.Data;

@Data
public class Patient {

    private Integer idPatient;
    private String firstName;
    private String lastName;
    private String dni;
    private String address;
    private String phone;
    private String email;

}
