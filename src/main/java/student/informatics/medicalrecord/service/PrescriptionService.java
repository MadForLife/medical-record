package student.informatics.medicalrecord.service;

import student.informatics.medicalrecord.data.dto.prescription.CreatePrescriptionDTO;
import student.informatics.medicalrecord.data.dto.prescription.SimplePrescriptionDTO;
import student.informatics.medicalrecord.data.dto.prescription.UpdatePrescriptionDTO;

import java.util.List;

public interface PrescriptionService {

    List<SimplePrescriptionDTO> findAllSimplePrescriptions();

    SimplePrescriptionDTO findSimplePrescriptionById(String id);

    SimplePrescriptionDTO createPrescription(CreatePrescriptionDTO createPrescriptionDTO);

    SimplePrescriptionDTO updatePrescription(UpdatePrescriptionDTO updatePrescriptionDTO, String id);

}
