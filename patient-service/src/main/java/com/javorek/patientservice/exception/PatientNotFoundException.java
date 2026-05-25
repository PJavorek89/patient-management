package com.javorek.patientservice.exception;

public class PatientNotFoundException extends RuntimeException{

    public PatientNotFoundException(String messasage){
        super(messasage);
    }

}
