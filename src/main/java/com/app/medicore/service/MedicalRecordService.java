package com.app.medicore.service;

import com.app.medicore.dto.MedicalRecordRequest;
import com.app.medicore.entity.MedicalRecord;

import java.util.List;

public interface MedicalRecordService {

    MedicalRecord createRecord(MedicalRecordRequest request);

    List<MedicalRecord> getPatientRecords(Long patientId);

    MedicalRecord getRecord(Long id);
}