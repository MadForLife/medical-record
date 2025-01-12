package student.informatics.medicalrecord.data.dto.sick_leave;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import student.informatics.medicalrecord.data.dto.appointment.SimpleAppointmentDTO;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSickLeaveDTO {

    private String reason;
    private LocalDate startDate;
    private LocalDate endDate;
    private SimpleAppointmentDTO appointment;
}
