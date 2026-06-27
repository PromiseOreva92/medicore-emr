package com.app.medicore.service.impl;

import com.app.medicore.dto.MedicalRecordRequest;
import com.app.medicore.entity.MedicalRecord;
import com.app.medicore.entity.Patient;
import com.app.medicore.exception.PatientNotFoundException;
import com.app.medicore.repository.MedicalRecordRepository;
import com.app.medicore.repository.PatientRepository;
import com.app.medicore.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private final MedicalRecordRepository
            medicalRecordRepository;

    private final PatientRepository
            patientRepository;

    @Override
    public MedicalRecord createRecord(
            MedicalRecordRequest request) {

        Patient patient =
                patientRepository.findById(
                                request.getPatientId())
                        .orElseThrow(() ->
                                new PatientNotFoundException(
                                        "Patient not found"));

        MedicalRecord record =
                MedicalRecord.builder()
                        .diagnosis(
                                request.getDiagnosis())
                        .treatment(
                                request.getTreatment())
                        .notes(
                                request.getNotes())
                        .visitDate(
                                LocalDateTime.now())
                        .patient(patient)
                        .build();

        return medicalRecordRepository
                .save(record);
    }

    @Override
    public List<MedicalRecord>
    getPatientRecords(Long patientId) {

        return medicalRecordRepository
                .findByPatientId(patientId);
    }

    @Override
    public MedicalRecord getRecord(Long id) {

        return medicalRecordRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Medical record not found"));
    }
}