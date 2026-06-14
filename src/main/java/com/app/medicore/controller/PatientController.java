package com.app.medicore.controller;

import com.app.medicore.dto.PatientRequest;
import com.app.medicore.entity.Patient;
import com.app.medicore.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public Patient createPatient(
            @Valid
            @RequestBody
            PatientRequest request) {

        return patientService
                .createPatient(request);
    }

    @GetMapping("/{id}")
    public Patient getPatient(
            @PathVariable Long id) {

        return patientService
                .getPatient(id);
    }

    @GetMapping
    public List<Patient> getAllPatients() {

        return patientService
                .getAllPatients();
    }

    @PutMapping("/{id}")
    public Patient updatePatient(
            @PathVariable Long id,
            @RequestBody PatientRequest request) {

        return patientService
                .updatePatient(id,
                        request);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(
            @PathVariable Long id) {

        patientService.deletePatient(id);
    }
}