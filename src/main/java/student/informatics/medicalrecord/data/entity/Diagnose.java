package student.informatics.medicalrecord.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "diagnoses")
public class Diagnose extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "appointments_id", nullable = false)
    private Appointment appointment;

    @ManyToOne
    @JoinColumn(name = "dcl_id", nullable = true)
    private DiagnoseCode diagnoseCode;

    @Column(name = "diagnose_description", nullable = true, length = 600)
    private String description;
}
