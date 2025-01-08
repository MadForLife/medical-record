package student.informatics.medicalrecord.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.informatics.medicalrecord.data.entity.Diagnose;
import student.informatics.medicalrecord.data.entity.DiagnoseCode;

import java.util.List;

public interface DiagnoseRepository extends JpaRepository<Diagnose, String> {

    List<Diagnose> findAllByDiagnoseCode(DiagnoseCode diagnoseCode);
}
