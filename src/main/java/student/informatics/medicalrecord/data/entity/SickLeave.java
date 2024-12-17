package student.informatics.medicalrecord.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "sick_leaves")
public class SickLeave extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "patients_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "appointments_id", nullable = false)
    private Appointment appointment;

    @Column(name = "sl_start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "sl_end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "sl_reason", nullable = true, length = 600)
    private String reason;
}
