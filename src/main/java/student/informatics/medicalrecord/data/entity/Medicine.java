package student.informatics.medicalrecord.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "medicines")
public class Medicine extends BaseEntity {

    @Column(name = "medicine_name", nullable = false, length = 50)
    private String name;

    @Column(name = "medicine_description", nullable = true, length = 600)
    private String description;

    @ManyToMany(mappedBy = "medicines")
    private Set<Prescription> prescriptions;
}
