package student.informatics.medicalrecord.service;

import student.informatics.medicalrecord.data.dto.diag_code.CreateDiagnoseCodeDTO;
import student.informatics.medicalrecord.data.dto.diag_code.SimpleDiagnoseCodeDTO;
import student.informatics.medicalrecord.data.dto.diag_code.UpdateDiagnoseCodeDTO;

import java.util.List;

public interface DiagnoseCodeService {

    List<SimpleDiagnoseCodeDTO> findAllSimpleDiagnoseCodes();
    SimpleDiagnoseCodeDTO findSimpleDiagnoseCodeById(String id);
    SimpleDiagnoseCodeDTO createDiagnoseCode(CreateDiagnoseCodeDTO createDiagnoseCodeDTO);
    SimpleDiagnoseCodeDTO updateDiagnoseCode(UpdateDiagnoseCodeDTO updateDiagnoseCodeDTO, String id);
    void deleteDiagnoseCode(String id);
}
