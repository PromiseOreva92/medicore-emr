package com.app.medicore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String doctorNumber;

    private String firstName;

    private String lastName;

    private String specialization;

    private String email;

    private String phone;

    private LocalDateTime createdAt;
}