package com.tlaxcala.security.encrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncrypt {
    public static void main(String[] args) {
        String rawPassword = "1234";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println("Contraseña codificada: " + encodedPassword);
    }
}
