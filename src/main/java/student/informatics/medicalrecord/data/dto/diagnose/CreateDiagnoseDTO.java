package student.informatics.medicalrecord.data.dto.diagnose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import student.informatics.medicalrecord.data.dto.appointment.SimpleAppointmentDTO;
import student.informatics.medicalrecord.data.dto.diag_code.SimpleDiagnoseCodeDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateDiagnoseDTO {

    private String appointmentId;
    private String diagnoseCodeId;
    private String description;
}
