package student.informatics.medicalrecord.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import student.informatics.medicalrecord.data.dto.diagnose.DiagnosisFrequencyDTO;
import student.informatics.medicalrecord.data.dto.diagnose.SimpleDiagnoseDTO;
import student.informatics.medicalrecord.data.entity.Diagnose;
import student.informatics.medicalrecord.data.entity.DiagnoseCode;

import java.util.List;

public interface DiagnoseRepository extends JpaRepository<Diagnose, String> {

    List<Diagnose> findAllByDiagnoseCode(DiagnoseCode diagnoseCode);

    // TODO Unit Test
    @Query("SELECT new student.informatics.medicalrecord.data.dto.diagnose.DiagnosisFrequencyDTO(dc.code, COUNT(d.id)) " +
            "FROM Diagnose d " +
            "JOIN d.diagnoseCode dc " +
            "GROUP BY dc.code " +
            "ORDER BY COUNT(d.id) DESC")
    List<DiagnosisFrequencyDTO> findMostFrequentDiagnoses();
}
