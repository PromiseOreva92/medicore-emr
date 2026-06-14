package com.app.medicore.service;

import com.app.medicore.dto.PatientRequest;
import com.app.medicore.entity.Patient;

import java.util.List;

public interface PatientService {

    Patient createPatient(PatientRequest request);

    Patient getPatient(Long id);

    List<Patient> getAllPatients();

    Patient updatePatient(Long id,
                          PatientRequest request);

    void deletePatient(Long id);
}