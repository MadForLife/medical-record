package student.informatics.medicalrecord.data.dto.diagnose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDiagnoseDTO {

    private String appointmentId;
    private String diagnoseCodeId;
    private String description;
}
