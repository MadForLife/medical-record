package student.informatics.medicalrecord.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "diagnose_code_list")
public class DiagnoseCode extends BaseEntity {

    @Column(name = "dc_name", nullable = false, length = 50)
    private String code;

    @OneToMany(mappedBy = "diagnoseCode")
    private Set<Diagnose> diagnoses;
}