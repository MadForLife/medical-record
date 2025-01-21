package student.informatics.medicalrecord.service;

import student.informatics.medicalrecord.data.dto.patient.SimplePatientDTO;
import student.informatics.medicalrecord.data.dto.patient.UpdatePatientDTO;
import student.informatics.medicalrecord.data.entity.Patient;

import java.util.List;

public interface PatientService {

    List<SimplePatientDTO> findAllSimplePatients();

    SimplePatientDTO findSimplePatientById(String id);

    SimplePatientDTO updatePatient(UpdatePatientDTO updatePatientDTO, String id);

    List<SimplePatientDTO> findAllSimplePatientsByDoctorId(String id);

    List<SimplePatientDTO> findPatientsByDiagnosisCode(String diagnosisCode);

}
