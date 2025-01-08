package student.informatics.medicalrecord.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student.informatics.medicalrecord.data.dto.diag_code.CreateDiagnoseCodeDTO;
import student.informatics.medicalrecord.data.dto.diag_code.SimpleDiagnoseCodeDTO;
import student.informatics.medicalrecord.data.dto.diag_code.UpdateDiagnoseCodeDTO;
import student.informatics.medicalrecord.service.DiagnoseCodeService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api.medical-record/v1/diagnose-codes")
public class DiagnoseCodeController {

    private final DiagnoseCodeService diagnoseCodeService;

    @GetMapping("/simple")
    public ResponseEntity<List<SimpleDiagnoseCodeDTO>> findAllDiagnoseCodes() {
        return ResponseEntity.ok(diagnoseCodeService.findAllSimpleDiagnoseCodes());
    }

    @GetMapping("/simple/{diagnose_code_id}")
    public ResponseEntity<SimpleDiagnoseCodeDTO> findSimpleDiagnoseCodeById(
            @PathVariable("diagnose_code_id") String id) {
        return ResponseEntity.ok(diagnoseCodeService.findSimpleDiagnoseCodeById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<SimpleDiagnoseCodeDTO> createDiagnoseCode(@RequestBody CreateDiagnoseCodeDTO createDiagnoseCodeDTO) {
        return ResponseEntity.ok(diagnoseCodeService.createDiagnoseCode(createDiagnoseCodeDTO));
    }

    @PutMapping("/{diagnose_code_id}/update")
    public ResponseEntity<SimpleDiagnoseCodeDTO> updateDiagnoseCodeById(
            @RequestBody UpdateDiagnoseCodeDTO updateDiagnoseCodeDTO,
            @PathVariable("diagnose_code_id") String id) {
        return ResponseEntity.ok(diagnoseCodeService.updateDiagnoseCode(updateDiagnoseCodeDTO, id));
    }

    @DeleteMapping("{diagnose_code_id}/delete")
    public ResponseEntity<Void> deleteDiagnoseCodeById(@PathVariable("diagnose_code_id") String id) {
        diagnoseCodeService.deleteDiagnoseCode(id);
        return ResponseEntity.noContent().build();
    }
}
