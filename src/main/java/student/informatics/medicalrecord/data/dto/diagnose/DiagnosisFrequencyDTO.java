package student.informatics.medicalrecord.data.dto.diagnose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosisFrequencyDTO {

    private String diagnoseCode;
    private Long diagnosisCount;
}
