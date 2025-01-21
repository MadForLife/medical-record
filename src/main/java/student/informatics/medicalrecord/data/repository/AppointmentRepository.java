package student.informatics.medicalrecord.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.informatics.medicalrecord.data.entity.Appointment;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {

    List<Appointment> findAllByDoctorId(String doctorId);
    List<Appointment> findAllByPatientId(String patientId);
}
