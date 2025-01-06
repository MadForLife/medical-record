package student.informatics.medicalrecord.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.informatics.medicalrecord.data.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, String> {
}
