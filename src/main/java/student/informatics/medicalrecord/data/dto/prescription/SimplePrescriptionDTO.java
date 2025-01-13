package student.informatics.medicalrecord.data.dto.prescription;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import student.informatics.medicalrecord.data.dto.appointment.SimpleAppointmentDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimplePrescriptionDTO {

    private String id;
    private String description;
    private SimpleAppointmentDTO appointment;
}
