package student.informatics.medicalrecord.data.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import student.informatics.medicalrecord.data.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, String> {

    @Modifying
    @Transactional
    @Query(value = "insert into patient (users_id, patient_ucn, patient_is_health_insured, doctors_id)" +
            " values (:userId, :pin, :isHealthInsured, :doctorId)", nativeQuery = true)
    void insertPatient(@Param("userId") String id,
                       @Param("pin") String pin,
                       @Param("isHealthInsured") Boolean isHealthInsured,
                       @Param("doctorId") String doctorId);
}
