package com.app.medicore.controller;

import com.app.medicore.dto.ApiResponse;
import com.app.medicore.dto.PatientRequest;
import com.app.medicore.entity.Patient;
import com.app.medicore.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public Patient createPatient(@Valid @RequestBody PatientRequest request) {
        return patientService.createPatient(request);
    }

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable Long id) {
        return patientService.getPatient(id);
    }

//    @GetMapping
//    public List<Patient> getAllPatients() {
//
//        return patientService
//                .getAllPatients();
//    }

    @GetMapping
    public Page<Patient> getAllPatients(
            @RequestParam(defaultValue = "0")int page,
            @RequestParam(defaultValue = "10")int size) {

        return patientService.getAllPatients(page, size);
    }

//    @GetMapping("/search")
//    public List<Patient> searchPatient(
//            @RequestParam String name) {
//
//        return patientService.search(name);
//    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id,@RequestBody PatientRequest request) {

        return patientService.updatePatient(id,request);
    }

//    @GetMapping("/search")
//    public Page<Patient> searchPatients(
//
//            @RequestParam String name,
//
//            @RequestParam(defaultValue = "0")
//            int page,
//
//            @RequestParam(defaultValue = "10")
//            int size) {
//
//        return patientService
//                .searchPatients(name, page, size);
//    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<Page<Patient>>> searchPatients(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<Patient> patients =patientService.searchPatients(name,page,size);

        return ResponseEntity.ok(
                ApiResponse.<Page<Patient>>builder()
                        .success(true)
                        .message("Patients retrieved successfully")
                        .data(patients)
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}