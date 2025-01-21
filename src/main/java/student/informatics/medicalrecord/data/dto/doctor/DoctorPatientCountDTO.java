package student.informatics.medicalrecord.data.dto.doctor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorPatientCountDTO {

    private String doctorName;
    private Long patientCount;
}
