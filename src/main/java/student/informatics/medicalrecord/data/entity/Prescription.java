package student.informatics.medicalrecord.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "prescriptions")
public class Prescription extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "appointments_id", nullable = false)
    private Appointment appointment;

    @Column(name = "prescription_description", nullable = true, length = 600)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "prescription_has_medicines",
            joinColumns = @JoinColumn(name = "prescriptions_id"),
            inverseJoinColumns = @JoinColumn(name = "medicines_id"))
    private Set<Medicine> medicines;
}
