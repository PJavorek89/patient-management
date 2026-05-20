package com.javorek.patientservice.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {

    @NotBlank
    @Size(max = 100, message = "Name must be more than 100 characters")
    private String name;

    @NotBlank
    @Email(message = "Email should be valid")
    private String email;

}
