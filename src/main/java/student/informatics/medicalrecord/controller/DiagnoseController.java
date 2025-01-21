package student.informatics.medicalrecord.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student.informatics.medicalrecord.data.dto.diagnose.CreateDiagnoseDTO;
import student.informatics.medicalrecord.data.dto.diagnose.DiagnosisFrequencyDTO;
import student.informatics.medicalrecord.data.dto.diagnose.SimpleDiagnoseDTO;
import student.informatics.medicalrecord.data.dto.diagnose.UpdateDiagnoseDTO;
import student.informatics.medicalrecord.service.DiagnoseService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8050")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api.medical-record/v1/diagnoses")
public class DiagnoseController {

    private final DiagnoseService diagnoseService;

    @GetMapping("/simple")
    public ResponseEntity<List<SimpleDiagnoseDTO>> findAllSimpleDiagnoses() {
        return ResponseEntity.ok(diagnoseService.findAllSimpleDiagnoses());
    }

    @GetMapping("/simple/{diagnose_id}")
    public ResponseEntity<SimpleDiagnoseDTO> findSimpleDiagnoseById(@PathVariable("diagnose_id") String id) {
        return ResponseEntity.ok(diagnoseService.findSimpleDiagnoseById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<SimpleDiagnoseDTO> createDiagnose(@RequestBody CreateDiagnoseDTO createDiagnoseDTO) {
        return ResponseEntity.ok(diagnoseService.createDiagnose(createDiagnoseDTO));
    }

    @PutMapping("/{diagnose_id}/update")
    public ResponseEntity<SimpleDiagnoseDTO> updateDiagnose(
            @RequestBody UpdateDiagnoseDTO updateDiagnoseDTO,
            @PathVariable("diagnose_id") String id) {
        return ResponseEntity.ok(diagnoseService.updateDiagnose(updateDiagnoseDTO, id));
    }

    @GetMapping("/most-frequent")
    public ResponseEntity<List<DiagnosisFrequencyDTO>> findMostFrequentDiagnoses() {
        return ResponseEntity.ok(diagnoseService.findMostFrequentDiagnoses());
    }
}
