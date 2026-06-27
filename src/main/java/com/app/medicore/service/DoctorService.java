package com.app.medicore.service;

import com.app.medicore.dto.DoctorRequest;
import com.app.medicore.entity.Doctor;

import java.util.List;

public interface DoctorService {

    Doctor createDoctor(
            DoctorRequest request);

    List<Doctor> getAllDoctors();

    Doctor getDoctor(Long id);
}
