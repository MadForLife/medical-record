package student.informatics.medicalrecord.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student.informatics.medicalrecord.data.dto.prescription.CreatePrescriptionDTO;
import student.informatics.medicalrecord.data.dto.prescription.SimplePrescriptionDTO;
import student.informatics.medicalrecord.data.dto.prescription.UpdatePrescriptionDTO;
import student.informatics.medicalrecord.service.PrescriptionService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api.medical-record/v1/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @GetMapping("/simple")
    public ResponseEntity<List<SimplePrescriptionDTO>> findAllSimplePrescriptions() {
        return ResponseEntity.ok(prescriptionService.findAllSimplePrescriptions());
    }

    @GetMapping("/simple/{prescription_id}")
    public ResponseEntity<SimplePrescriptionDTO> findSimplePrescriptionById(@PathVariable("prescription_id") String id) {
        return ResponseEntity.ok(prescriptionService.findSimplePrescriptionById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<SimplePrescriptionDTO> createPrescription(@RequestBody CreatePrescriptionDTO createPrescriptionDTO) {
        return ResponseEntity.ok(prescriptionService.createPrescription(createPrescriptionDTO));
    }

    @PutMapping("/{prescription_id}/update")
    public ResponseEntity<SimplePrescriptionDTO> updatePrescription(
            @RequestBody UpdatePrescriptionDTO updatePrescriptionDTO,
            @PathVariable("prescription_id") String id) {
        return ResponseEntity.ok(prescriptionService.updatePrescription(updatePrescriptionDTO, id));
    }
}
