package com.app.medicore.controller;

import com.app.medicore.dto.MedicalRecordRequest;
import com.app.medicore.entity.MedicalRecord;
import com.app.medicore.service.MedicalRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-records")
@RequiredArgsConstructor
public class MedicalRecordController {

    private final MedicalRecordService
            medicalRecordService;

    @PostMapping
    public MedicalRecord createRecord(
            @Valid
            @RequestBody
            MedicalRecordRequest request) {

        return medicalRecordService
                .createRecord(request);
    }

    @GetMapping("/{id}")
    public MedicalRecord getRecord(
            @PathVariable Long id) {

        return medicalRecordService
                .getRecord(id);
    }

    @GetMapping("/patient/{patientId}")
    public List<MedicalRecord>
    getPatientRecords(
            @PathVariable Long patientId) {

        return medicalRecordService
                .getPatientRecords(patientId);
    }
}