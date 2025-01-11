package student.informatics.medicalrecord.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
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

    @Column(name = "patient_is_health_insured", nullable = false)
    private Boolean isHealthInsured;

    @ManyToOne
    @JoinColumn(name = "doctors_id", nullable = true)
    private Doctor personalDoctor;

    @OneToMany(mappedBy = "patient")
    private Set<Appointment> appointments;
}