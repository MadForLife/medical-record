package student.informatics.medicalrecord.data.dto.appointment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import student.informatics.medicalrecord.data.dto.doctor.SimpleDoctorDTO;
import student.informatics.medicalrecord.data.dto.patient.SimplePatientDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimpleAppointmentDTO {

    private String id;
    private SimplePatientDTO patient;
    private SimpleDoctorDTO doctor;
    private LocalDateTime appointmentDate;
}
