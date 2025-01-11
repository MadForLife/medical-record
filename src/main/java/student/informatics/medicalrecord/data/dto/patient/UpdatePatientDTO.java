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
public class UpdatePatientDTO {

    private String ucn;
    private Boolean isHealthInsured;
    private String doctorId;
}
