package com.app.medicore.service.impl;
import com.app.medicore.dto.DoctorRequest;
import com.app.medicore.entity.Doctor;
import com.app.medicore.repository.DoctorRepository;
import com.app.medicore.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl
        implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public Doctor createDoctor(
            DoctorRequest request) {

        Doctor doctor = Doctor.builder()
                .doctorNumber(
                        "DOC-" +
                                UUID.randomUUID()
                                        .toString()
                                        .substring(0, 8)
                )
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .specialization(
                        request.getSpecialization())
                .email(request.getEmail())
                .phone(request.getPhone())
                .createdAt(LocalDateTime.now())
                .build();

        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctor(Long id) {

        return doctorRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Doctor not found"));
    }
}
