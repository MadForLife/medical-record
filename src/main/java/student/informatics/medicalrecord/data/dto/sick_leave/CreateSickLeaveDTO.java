package student.informatics.medicalrecord.data.dto.sick_leave;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSickLeaveDTO {

    private String reason;
    private LocalDate startDate;
    private LocalDate endDate;
    private String appointmentId;
}
