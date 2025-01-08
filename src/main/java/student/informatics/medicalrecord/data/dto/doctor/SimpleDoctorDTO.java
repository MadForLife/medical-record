package student.informatics.medicalrecord.data.dto.doctor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimpleDoctorDTO {

    private String id;
    private String firstName;
    private String lastName;
    private Boolean isPersonalDoctor;
}