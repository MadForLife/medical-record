package student.informatics.medicalrecord.data.dto.doc_specialities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UpdateDoctorSpecialityDTO {

    private String name;
    private String description;
}
