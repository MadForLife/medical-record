package student.informatics.medicalrecord.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.informatics.medicalrecord.data.entity.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, String> {
}
