package com.app.medicore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String patientNumber;

    private String firstName;

    private String lastName;

    private String gender;

    private LocalDate dateOfBirth;

    private String phone;

    private String address;

    private String emergencyContact;

    private LocalDateTime createdAt;
}