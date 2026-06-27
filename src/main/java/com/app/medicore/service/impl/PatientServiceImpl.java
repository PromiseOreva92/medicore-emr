package com.app.medicore.service.impl;

import com.app.medicore.dto.PatientRequest;
import com.app.medicore.entity.Patient;
import com.app.medicore.exception.PatientNotFoundException;
import com.app.medicore.repository.PatientRepository;
import com.app.medicore.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
                        new PatientNotFoundException(
                                "Patient not found with id " + id));
    }




    //    public List<Patient> getAllPatients() {
//
//        return patientRepository.findAll();
//    }
    @Override
    public Page<Patient> getAllPatients(
            int page,
            int size) {

        return patientRepository.findAll(
                PageRequest.of(page, size)
        );
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

    @Override
    public Page<Patient> searchPatients(
            String name,
            int page,
            int size) {

        return patientRepository
                .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
                        name,
                        name,
                        PageRequest.of(page, size)
                );
    }
}