package student.informatics.medicalrecord.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.informatics.medicalrecord.data.entity.SickLeave;

public interface SickLeaveRepository extends JpaRepository<SickLeave, String> {
}
