package com.app.medicore.service.impl;

import com.app.medicore.dto.PatientRequest;
import com.app.medicore.entity.Patient;
import com.app.medicore.repository.PatientRepository;
import com.app.medicore.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl
        implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public Patient createPatient(
            PatientRequest request) {

        Patient patient = Patient.builder()
                .patientNumber(
                        UUID.randomUUID()
                                .toString()
                                .substring(0,8)
                )
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .gender(request.getGender())
                .dateOfBirth(request.getDateOfBirth())
                .phone(request.getPhone())
                .address(request.getAddress())
                .emergencyContact(
                        request.getEmergencyContact())
                .createdAt(LocalDateTime.now())
                .build();

        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatient(Long id) {

        return patientRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Patient not found"));
    }

    @Override
    public List<Patient> getAllPatients() {

        return patientRepository.findAll();
    }

    @Override
    public Patient updatePatient(
            Long id,
            PatientRequest request) {

        Patient patient = getPatient(id);

        patient.setFirstName(
                request.getFirstName());

        patient.setLastName(
                request.getLastName());

        patient.setGender(
                request.getGender());

        patient.setDateOfBirth(
                request.getDateOfBirth());

        patient.setPhone(
                request.getPhone());

        patient.setAddress(
                request.getAddress());

        patient.setEmergencyContact(
                request.getEmergencyContact());

        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {

        patientRepository.deleteById(id);
    }
}