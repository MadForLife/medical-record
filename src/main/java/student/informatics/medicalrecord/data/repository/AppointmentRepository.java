package student.informatics.medicalrecord.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.informatics.medicalrecord.data.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {
}
