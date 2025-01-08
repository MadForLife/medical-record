package student.informatics.medicalrecord.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student.informatics.medicalrecord.data.dto.medicine.CreateMedicineDTO;
import student.informatics.medicalrecord.data.dto.medicine.SimpleMedicineDTO;
import student.informatics.medicalrecord.data.dto.medicine.UpdateMedicineDTO;
import student.informatics.medicalrecord.service.MedicineService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api.medical-record/v1/medicines")
public class MedicineController {

    private final MedicineService medicineService;

    @GetMapping("/simple")
    public ResponseEntity<List<SimpleMedicineDTO>> findAllSimpleMedicines() {
        return ResponseEntity.ok(medicineService.findAllSimpleMedicines());
    }

    @GetMapping("/simple/{medicine_id}")
    public SimpleMedicineDTO findSimpleMedicineById(@PathVariable("medicine_id") String id) {
        return medicineService.findSimpleMedicineById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<SimpleMedicineDTO> createMedicine(@RequestBody CreateMedicineDTO createMedicineDTO) {
        return ResponseEntity.ok(medicineService.createMedicine(createMedicineDTO));
    }

    @PutMapping("/{medicine_id}/update")
    public ResponseEntity<SimpleMedicineDTO> updateMedicineById(@RequestBody UpdateMedicineDTO updateMedicineDTO,
                                                                @PathVariable("medicine_id") String id) {
        return ResponseEntity.ok(medicineService.updateMedicine(updateMedicineDTO, id));
    }

    @DeleteMapping("/{medicine_id}/delete")
    public ResponseEntity<Void> deleteMedicineById(@PathVariable("medicine_id") String id) {
        medicineService.deleteMedicineById(id);
        return ResponseEntity.noContent().build();
    }
}
