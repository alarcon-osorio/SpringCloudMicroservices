package com.tlaxcala.security.encrypt;

import org.jasypt.util.text.BasicTextEncryptor;

//Clase que encryta jsypet BD Y otros
public class JasyptEncrypt {
    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("tlaxcala");

        String encryptedText = textEncryptor.encrypt("jdbc:postgresql://172.17.0.5:5432/mediapp_2023_1");
        System.out.println("Encrypted Text: " + encryptedText);
    }
}
