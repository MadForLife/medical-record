package student.informatics.medicalrecord.data.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import student.informatics.medicalrecord.data.entity.Doctor;
import student.informatics.medicalrecord.data.entity.DoctorSpeciality;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, String> {

    @Modifying
    @Transactional
    @Query(value = "insert into doctor (users_id, doctor_is_personal_doctor) values (:userId, :isPersonalDoctor)", nativeQuery = true)
    void insertDoctor(@Param("userId") String id,
                      @Param("isPersonalDoctor") Boolean isPersonalDoctor);

    List<Doctor> findAllBySpecialitiesContaining(DoctorSpeciality speciality);
}
