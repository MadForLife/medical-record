package student.informatics.medicalrecord.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.informatics.medicalrecord.data.entity.Medicine;
import student.informatics.medicalrecord.data.entity.Prescription;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, String> {

    List<Prescription> findAllByMedicinesContaining(Medicine medicine);
}
