package student.informatics.medicalrecord.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import student.informatics.medicalrecord.data.dto.appointment.CreateAppointmentDTO;
import student.informatics.medicalrecord.data.dto.appointment.SimpleAppointmentDTO;
import student.informatics.medicalrecord.data.dto.appointment.UpdateAppointmentDTO;
import student.informatics.medicalrecord.data.entity.Appointment;
import student.informatics.medicalrecord.data.entity.Doctor;
import student.informatics.medicalrecord.data.entity.Patient;
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
}
