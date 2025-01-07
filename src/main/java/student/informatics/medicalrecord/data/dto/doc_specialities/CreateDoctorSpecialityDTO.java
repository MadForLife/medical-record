package student.informatics.medicalrecord.data.dto.doc_specialities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateDoctorSpecialityDTO {

    private String name;
    private String description;
}
