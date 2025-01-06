package student.informatics.medicalrecord.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.informatics.medicalrecord.data.entity.DiagnoseCode;

public interface DiagnoseCodeRepository extends JpaRepository<DiagnoseCode, String> {
}
