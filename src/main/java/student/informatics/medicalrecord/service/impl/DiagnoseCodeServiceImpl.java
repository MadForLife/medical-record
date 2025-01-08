package student.informatics.medicalrecord.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import student.informatics.medicalrecord.data.dto.diag_code.CreateDiagnoseCodeDTO;
import student.informatics.medicalrecord.data.dto.diag_code.SimpleDiagnoseCodeDTO;
import student.informatics.medicalrecord.data.dto.diag_code.UpdateDiagnoseCodeDTO;
import student.informatics.medicalrecord.data.entity.Diagnose;
import student.informatics.medicalrecord.data.entity.DiagnoseCode;
import student.informatics.medicalrecord.data.repository.DiagnoseCodeRepository;
import student.informatics.medicalrecord.data.repository.DiagnoseRepository;
import student.informatics.medicalrecord.exception.DiagnoseCodeNotFoundException;
import student.informatics.medicalrecord.service.DiagnoseCodeService;
import student.informatics.medicalrecord.utility.ModelMapperUtil;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DiagnoseCodeServiceImpl implements DiagnoseCodeService {

    private final DiagnoseCodeRepository diagnoseCodeRepository;
    private final DiagnoseRepository diagnoseRepository;
    private final ModelMapperUtil modelMapperUtil;

    @Override
    public List<SimpleDiagnoseCodeDTO> findAllSimpleDiagnoseCodes() {
        return modelMapperUtil
                .mapList(diagnoseCodeRepository.findAll(), SimpleDiagnoseCodeDTO.class);
    }

    @Override
    public SimpleDiagnoseCodeDTO findSimpleDiagnoseCodeById(String id) {

        DiagnoseCode diagnoseCode = diagnoseCodeRepository.findById(id)
                .orElseThrow(() -> new DiagnoseCodeNotFoundException(String.format("Diagnose code with ID: '%s' not found", id)));

        return modelMapperUtil
                .map(diagnoseCode, SimpleDiagnoseCodeDTO.class);
    }

    @Override
    public SimpleDiagnoseCodeDTO createDiagnoseCode(CreateDiagnoseCodeDTO createDiagnoseCodeDTO) {

        DiagnoseCode diagnoseCode = DiagnoseCode.builder()
                .code(createDiagnoseCodeDTO.getCode())
                .build();

        return modelMapperUtil
                .map(diagnoseCodeRepository.save(diagnoseCode), SimpleDiagnoseCodeDTO.class);
    }

    @Override
    public SimpleDiagnoseCodeDTO updateDiagnoseCode(UpdateDiagnoseCodeDTO updateDiagnoseCodeDTO, String id) {

        DiagnoseCode diagnoseCode = diagnoseCodeRepository.findById(id)
                .orElseThrow(() -> new DiagnoseCodeNotFoundException(String.format("Diagnose code with ID: '%s' not found", id)));

        diagnoseCode.setCode(updateDiagnoseCodeDTO.getCode());

        return modelMapperUtil.map(diagnoseCodeRepository.save(diagnoseCode), SimpleDiagnoseCodeDTO.class);
    }

    @Override
    @Transactional
    public void deleteDiagnoseCode(String id) {

        DiagnoseCode diagnoseCode = diagnoseCodeRepository.findById(id)
                .orElseThrow(() -> new DiagnoseCodeNotFoundException(String.format("Diagnose code with ID: '%s' not found", id)));

        List<Diagnose> associatedDiagnoses = diagnoseRepository
                .findAllByDiagnoseCode(diagnoseCode);

        associatedDiagnoses.forEach(diagnose -> {
            diagnose.setDiagnoseCode(null);
            diagnoseRepository.save(diagnose);
        });

        diagnoseCodeRepository.delete(diagnoseCode);
    }
}
