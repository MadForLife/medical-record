package student.informatics.medicalrecord.data.dto.prescription;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePrescriptionDTO {

    private String description;
    private String appointmentId;
}
