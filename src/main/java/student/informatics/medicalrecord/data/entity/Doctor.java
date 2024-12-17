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
public class Doctor extends User {

    @Column(name = "doctor_is_personal_doctor", nullable = false,
            columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isPersonalDoctor;

    @OneToMany(mappedBy = "personalDoctor")
    private Set<Patient> patients;

    @ManyToMany
    @JoinTable(
            name = "doc_has_specialities",
            joinColumns = @JoinColumn(name = "doctors_id"),
            inverseJoinColumns = @JoinColumn(name = "doc_spec_id"))
    private Set<DoctorSpeciality> specialities;

    @OneToMany(mappedBy = "doctor")
    private Set<Appointment> appointments;
}