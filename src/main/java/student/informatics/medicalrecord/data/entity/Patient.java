package student.informatics.medicalrecord.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "users_id")
public class Patient extends User {

    @Column(name = "patient_ucn", nullable = false, length = 20)
    private String ucn;

    @Column(name = "patient_is_health_insured", nullable = false,
            columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isHealthInsured;

    @ManyToOne
    @JoinColumn(name = "doctors_id", nullable = false)
    private Doctor personalDoctor;

    @OneToMany(mappedBy = "patient")
    private Set<Appointment> appointments;
}