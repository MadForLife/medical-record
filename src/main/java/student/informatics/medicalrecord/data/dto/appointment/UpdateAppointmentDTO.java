package student.informatics.medicalrecord.data.dto.appointment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAppointmentDTO {

    private String patientId;
    private String doctorId;
    private LocalDateTime appointmentDate;
}
