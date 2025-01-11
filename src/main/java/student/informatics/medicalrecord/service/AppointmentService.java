package student.informatics.medicalrecord.service;

import student.informatics.medicalrecord.data.dto.appointment.CreateAppointmentDTO;
import student.informatics.medicalrecord.data.dto.appointment.SimpleAppointmentDTO;
import student.informatics.medicalrecord.data.dto.appointment.UpdateAppointmentDTO;

import java.util.List;

public interface AppointmentService {

    List<SimpleAppointmentDTO> findAllSimpleAppointments();

    SimpleAppointmentDTO findSimpleAppointmentById(String id);

    SimpleAppointmentDTO updateAppointment(UpdateAppointmentDTO updateAppointmentDTO, String id);

    SimpleAppointmentDTO createAppointment(CreateAppointmentDTO createAppointmentDTO);

    // TODO Delete Appointment

}
