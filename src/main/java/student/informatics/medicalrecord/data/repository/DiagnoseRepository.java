package student.informatics.medicalrecord.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.informatics.medicalrecord.data.entity.Diagnose;

public interface DiagnoseRepository extends JpaRepository<Diagnose, String> {
}
