package student.informatics.medicalrecord.data.dto.medicine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimpleMedicineDTO {

    private String id;
    private String name;
    private String description;
}
