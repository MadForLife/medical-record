package student.informatics.medicalrecord.data.dto.patient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import student.informatics.medicalrecord.data.dto.doctor.SimpleDoctorDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimplePatientDTO {

    private String id;
    private String ucn;
    private String firstName;
    private String lastName;
    private Boolean isHealthInsured;
    private SimpleDoctorDTO doctor;
}
