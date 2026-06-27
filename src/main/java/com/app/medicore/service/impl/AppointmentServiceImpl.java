package com.app.medicore.service.impl;

import com.app.medicore.dto.AppointmentNotificationEvent;
import com.app.medicore.dto.AppointmentRequest;
import com.app.medicore.entity.Appointment;
import com.app.medicore.entity.Doctor;
import com.app.medicore.entity.Patient;
import com.app.medicore.repository.AppointmentRepository;
import com.app.medicore.repository.DoctorRepository;
import com.app.medicore.repository.PatientRepository;
import com.app.medicore.service.AppointmentService;
import com.app.medicore.service.NotificationProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl
        implements AppointmentService {

    private final AppointmentRepository
            appointmentRepository;

    private final PatientRepository
            patientRepository;

    private final DoctorRepository
            doctorRepository;

    private final NotificationProducer
            notificationProducer;

    @Override
    public Appointment scheduleAppointment(
            AppointmentRequest request) {

        Patient patient =
                patientRepository.findById(
                                request.getPatientId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Patient not found"));

        Doctor doctor =
                doctorRepository.findById(
                                request.getDoctorId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Doctor not found"));

        Appointment appointment =
                Appointment.builder()
                        .patient(patient)
                        .doctor(doctor)
                        .appointmentDate(
                                request.getAppointmentDate())
                        .reason(
                                request.getReason())
                        .status("SCHEDULED")
                        .build();



        //added

        Appointment saved = appointmentRepository.save(appointment);

        AppointmentNotificationEvent event =
                AppointmentNotificationEvent
                        .builder()
                        .appointmentId(saved.getId())
                        .patientId(patient.getId())
                        .doctorId(doctor.getId())
                        .patientName(
                                patient.getFirstName()
                                        + " "
                                        + patient.getLastName())
                        .doctorName(
                                doctor.getFirstName()
                                        + " "
                                        + doctor.getLastName())
                        .patientPhone(
                                patient.getPhone())
                        .appointmentDate(
                                saved
                                        .getAppointmentDate()
                                        .toString())
                        .build();

        notificationProducer.publishAppointmentNotification(event);

        return saved;
//        return appointmentRepository
//                .save(appointment);
    }

    @Override
    public List<Appointment>
    getPatientAppointments(Long patientId) {

        return appointmentRepository
                .findByPatientId(patientId);
    }

    @Override
    public List<Appointment>
    getDoctorAppointments(Long doctorId) {

        return appointmentRepository
                .findByDoctorId(doctorId);
    }





}
