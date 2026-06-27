package com.app.medicore.service;

import com.app.medicore.dto.PatientRequest;
import com.app.medicore.entity.Patient;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PatientService {

    Patient createPatient(PatientRequest request);

    Patient getPatient(Long id);

//    List<Patient> getAllPatients();

    Page<Patient> getAllPatients(int page, int size);

    Patient updatePatient(Long id,
                          PatientRequest request);

    void deletePatient(Long id);

    Page<Patient> searchPatients(String name,
                                 int page,
                                 int size);
}