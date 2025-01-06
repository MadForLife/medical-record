package student.informatics.medicalrecord.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.informatics.medicalrecord.data.entity.DoctorSpeciality;

public interface DoctorSpecialityRepository extends JpaRepository<DoctorSpeciality, String> {
}
