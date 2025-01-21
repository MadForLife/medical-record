package student.informatics.medicalrecord.data.dto.medicine;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MedicineIdsRequestDTO {

    private List<String> medicineIds;


}
