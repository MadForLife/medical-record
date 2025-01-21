package student.informatics.medicalrecord.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student.informatics.medicalrecord.data.dto.patient.SimplePatientDTO;
import student.informatics.medicalrecord.data.dto.patient.UpdatePatientDTO;
import student.informatics.medicalrecord.data.entity.Patient;
import student.informatics.medicalrecord.service.PatientService;

import java.util.List;

@RequiredArgsConstructor

@CrossOrigin(origins = "http://localhost:8050")
@RestController
@RequestMapping("/api.medical-record/v1/patients")
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/simple")
    public ResponseEntity<List<SimplePatientDTO>> findAllSimplePatients() {
        return ResponseEntity.ok(patientService.findAllSimplePatients());
    }

    @GetMapping("/simple/{patient_id}")
    public ResponseEntity<SimplePatientDTO> findSimplePatientById(@PathVariable("patient_id") String id) {
        return ResponseEntity.ok(patientService.findSimplePatientById(id));
    }

    @PutMapping("/{patient_id}/update")
    public ResponseEntity<SimplePatientDTO> updatePatientById(@RequestBody UpdatePatientDTO updatePatientDTO,
                                                          @PathVariable("patient_id") String id) {
        return ResponseEntity.ok(patientService.updatePatient(updatePatientDTO, id));
    }

    @GetMapping("/simple/{doctor_id}/doctor")
    public ResponseEntity<List<SimplePatientDTO>> findSimplePatientByDoctorId(@PathVariable("doctor_id") String id) {
     return ResponseEntity.ok(patientService.findAllSimplePatientsByDoctorId(id));
    }

    @GetMapping("/simple/{diagnose_code_id}/diagnose-code")
    public ResponseEntity<List<SimplePatientDTO>> findPatientsByDiagnosisCode(
            @PathVariable("diagnose_code_id") String id) {
                return ResponseEntity.ok(patientService.findPatientsByDiagnosisCode(id));
    }

    // TODO Delete Endpoint


}
