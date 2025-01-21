package student.informatics.medicalrecord.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import student.informatics.medicalrecord.data.dto.appointment.DetailedAppointmentDTO;
import student.informatics.medicalrecord.data.dto.appointment.CreateAppointmentDTO;
import student.informatics.medicalrecord.data.dto.appointment.SimpleAppointmentDTO;
import student.informatics.medicalrecord.data.dto.appointment.UpdateAppointmentDTO;
import student.informatics.medicalrecord.data.dto.diagnose.SimpleDiagnoseDTO;
import student.informatics.medicalrecord.data.dto.prescription.PrescriptionMedicinesDTO;
import student.informatics.medicalrecord.data.dto.prescription.SimplePrescriptionDTO;
import student.informatics.medicalrecord.data.entity.*;
import student.informatics.medicalrecord.data.repository.AppointmentRepository;
import student.informatics.medicalrecord.data.repository.DoctorRepository;
import student.informatics.medicalrecord.data.repository.PatientRepository;
import student.informatics.medicalrecord.exception.AppointmentNotFoundException;
import student.informatics.medicalrecord.exception.DoctorNotFoundException;
import student.informatics.medicalrecord.exception.PatientNotFoundException;
import student.informatics.medicalrecord.service.AppointmentService;
import student.informatics.medicalrecord.utility.ModelMapperUtil;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ModelMapperUtil modelMapperUtil;

    @Override
    public List<SimpleAppointmentDTO> findAllSimpleAppointments() {
        return modelMapperUtil
                .mapList(appointmentRepository.findAll(), SimpleAppointmentDTO.class);
    }

    @Override
    public SimpleAppointmentDTO findSimpleAppointmentById(String id) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException(String.format("Appointment with ID: '%s' not found", id)));

        return modelMapperUtil.map(appointment, SimpleAppointmentDTO.class);
    }


    @Override
    public SimpleAppointmentDTO updateAppointment(UpdateAppointmentDTO updateAppointmentDTO, String id) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException(String.format("Appointment with ID: '%s' not found", id)));

        Doctor doctor = doctorRepository.findById(updateAppointmentDTO.getDoctorId())
                .orElseThrow(() -> new DoctorNotFoundException(String.format("Doctor with ID: '%s' not found", id)));

        Patient patient = patientRepository.findById(updateAppointmentDTO.getPatientId())
                .orElseThrow(() -> new PatientNotFoundException(String.format("Patient with ID: '%s' not found", id)));

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setAppointmentDate(updateAppointmentDTO.getAppointmentDate());

        return modelMapperUtil.map(appointmentRepository.save(appointment), SimpleAppointmentDTO.class);
    }

    @Override
    public SimpleAppointmentDTO createAppointment(CreateAppointmentDTO createAppointmentDTO) {

        Appointment appointment = new Appointment();

        Doctor doctor = doctorRepository.findById(createAppointmentDTO.getDoctorId())
                .orElseThrow(() -> new DoctorNotFoundException(String.format("Doctor with ID: '%s' not found", createAppointmentDTO.getDoctorId())));

        Patient patient = patientRepository.findById(createAppointmentDTO.getPatientId())
                .orElseThrow(() -> new PatientNotFoundException(String.format("Patient with ID: '%s' not found", createAppointmentDTO.getPatientId())));

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentDate(createAppointmentDTO.getAppointmentDate());

        return modelMapperUtil.map(appointmentRepository.save(appointment), SimpleAppointmentDTO.class);
    }

    @Override
    public List<SimpleAppointmentDTO> findAllSimpleAppointmentsByDoctorId(String doctorId) {

        List<Appointment> appointments = appointmentRepository.findAllByDoctorId(doctorId);

        return modelMapperUtil.mapList(appointments, SimpleAppointmentDTO.class);
    }

    @Override
    public List<SimpleAppointmentDTO> findAllSimpleAppointmentsByPatientId(String patientId) {

        List<Appointment> appointments = appointmentRepository.findAllByPatientId(patientId);

        return modelMapperUtil.mapList(appointments, SimpleAppointmentDTO.class);
    }

    @Override
    public DetailedAppointmentDTO findAppointmentDetailedById(String id) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException(String.format("Appointment with ID: '%s' not found", id)));

        DetailedAppointmentDTO detailedAppointmentDTO = modelMapperUtil.map(appointment, DetailedAppointmentDTO.class);

        if (appointment.getDiagnoses() != null && !appointment.getDiagnoses().isEmpty()) {

            Diagnose diagnose = appointment.getDiagnoses().iterator().next();
            SimpleDiagnoseDTO simpleDiagnoseDTO = modelMapperUtil.map(diagnose, SimpleDiagnoseDTO.class);
            detailedAppointmentDTO.setDiagnose(simpleDiagnoseDTO);
        }

        if (appointment.getPrescriptions() != null && !appointment.getPrescriptions().isEmpty()) {

            Prescription prescription = appointment.getPrescriptions().iterator().next();
            PrescriptionMedicinesDTO prescriptionMedicinesDTO = modelMapperUtil.map(prescription, PrescriptionMedicinesDTO.class);
            detailedAppointmentDTO.setPrescription(prescriptionMedicinesDTO);
        }

        return detailedAppointmentDTO;
    }
}
