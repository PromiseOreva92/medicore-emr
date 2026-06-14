package com.app.medicore.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String gender;

    @NotNull
    private LocalDate dateOfBirth;

    @NotBlank
    private String phone;

    private String address;

    private String emergencyContact;
}