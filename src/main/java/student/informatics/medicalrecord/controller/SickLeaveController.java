package student.informatics.medicalrecord.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student.informatics.medicalrecord.data.dto.sick_leave.CreateSickLeaveDTO;
import student.informatics.medicalrecord.data.dto.sick_leave.SimpleSickLeaveDTO;
import student.informatics.medicalrecord.data.dto.sick_leave.UpdateSickLeaveDTO;
import student.informatics.medicalrecord.service.SickLeaveService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api.medical-record/v1/sick-leaves")
public class SickLeaveController {

    private final SickLeaveService sickLeaveService;

    @GetMapping("/simple")
    public ResponseEntity<List<SimpleSickLeaveDTO>> findAllSimpleSickLeaves() {
        return ResponseEntity.ok(sickLeaveService.findAllSimpleSickLeaves());
    }

    @GetMapping("/simple/{sick_leave_id}")
    public ResponseEntity<SimpleSickLeaveDTO> findSimpleSickLeaveById(@PathVariable("sick_leave_id") String id) {
        return ResponseEntity.ok(sickLeaveService.findSimpleSickLeaveById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<SimpleSickLeaveDTO> createSickLeave(
            @RequestBody CreateSickLeaveDTO createSickLeaveDTO) {
        return ResponseEntity.ok(sickLeaveService.createSickLeave(createSickLeaveDTO));
    }

    @PutMapping("{sick_leave_id}/update")
    public ResponseEntity<SimpleSickLeaveDTO> updateSickLeave(
            @RequestBody UpdateSickLeaveDTO updateSickLeaveDTO,
            @PathVariable("sick_leave_id") String id) {
        return ResponseEntity.ok(sickLeaveService.updateSickLeave(updateSickLeaveDTO, id));
    }
}
