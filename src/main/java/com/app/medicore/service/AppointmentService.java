package com.app.medicore.service;

import com.app.medicore.dto.AppointmentRequest;
import com.app.medicore.entity.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment scheduleAppointment(
            AppointmentRequest request);

    List<Appointment>
    getPatientAppointments(Long patientId);

    List<Appointment>
    getDoctorAppointments(Long doctorId);
}
