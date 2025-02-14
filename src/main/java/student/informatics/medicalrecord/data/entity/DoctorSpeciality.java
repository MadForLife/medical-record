package student.informatics.medicalrecord.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Set;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "doc_specialities")
public class DoctorSpeciality extends BaseEntity {

    @Column(name = "doc_spec_name", nullable = false, length = 100)
    private String name;

    @Column(name = "doc_spec_description", length = 600)
    private String description;

    @ManyToMany(mappedBy = "specialities")
    private Set<Doctor> doctors;
}