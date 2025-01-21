package student.informatics.medicalrecord.data.dto.appointment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import student.informatics.medicalrecord.data.dto.diagnose.SimpleDiagnoseDTO;
import student.informatics.medicalrecord.data.dto.doctor.SimpleDoctorDTO;
import student.informatics.medicalrecord.data.dto.patient.SimplePatientDTO;
import student.informatics.medicalrecord.data.dto.prescription.PrescriptionMedicinesDTO;

@Getter
@Setter
@NoArgsConstructor
public class DetailedAppointmentDTO {

    private String id;
    private String appointmentDate;
    private SimpleDoctorDTO doctor;
    private SimplePatientDTO patient;
    private PrescriptionMedicinesDTO prescription;
    private SimpleDiagnoseDTO diagnose;

}
