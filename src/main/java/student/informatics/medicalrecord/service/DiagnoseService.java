package student.informatics.medicalrecord.service;

import student.informatics.medicalrecord.data.dto.diagnose.CreateDiagnoseDTO;
import student.informatics.medicalrecord.data.dto.diagnose.DiagnosisFrequencyDTO;
import student.informatics.medicalrecord.data.dto.diagnose.SimpleDiagnoseDTO;
import student.informatics.medicalrecord.data.dto.diagnose.UpdateDiagnoseDTO;
import student.informatics.medicalrecord.data.dto.doctor.DoctorPatientCountDTO;

import java.util.List;

public interface DiagnoseService {

    List<SimpleDiagnoseDTO> findAllSimpleDiagnoses();

    SimpleDiagnoseDTO findSimpleDiagnoseById(String id);

    SimpleDiagnoseDTO createDiagnose(CreateDiagnoseDTO createDiagnoseDTO);

    SimpleDiagnoseDTO updateDiagnose(UpdateDiagnoseDTO updateDiagnoseDTO, String id);

    List<DiagnosisFrequencyDTO> findMostFrequentDiagnoses();

}
