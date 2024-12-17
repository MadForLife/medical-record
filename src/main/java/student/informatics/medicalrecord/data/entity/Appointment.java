package student.informatics.medicalrecord.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "patients_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctors_id", nullable = false)
    private Doctor doctor;

    @Column(name = "appointments_visit_date", nullable = false)
    private LocalDateTime appointmentDate;

    @OneToMany(mappedBy = "appointment")
    private Set<SickLeave> sickLeaves;

    @OneToMany(mappedBy = "appointment")
    private Set<Diagnose> diagnoses;

    @OneToMany(mappedBy = "appointment")
    private Set<Prescription> prescriptions;
}
