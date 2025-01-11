package student.informatics.medicalrecord.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student.informatics.medicalrecord.data.dto.doctor.DoctorSpecialitiesDTO;
import student.informatics.medicalrecord.data.dto.doctor.SimpleDoctorDTO;
import student.informatics.medicalrecord.data.dto.doctor.UpdateDoctorStatusDTO;
import student.informatics.medicalrecord.service.DoctorService;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api.medical-record/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/simple")
    public ResponseEntity<List<SimpleDoctorDTO>> findAllSimpleDoctors() {
        return ResponseEntity.ok(doctorService.findAllSimpleDoctors());
    }

    @GetMapping("/simple/{doctor_id}")
    public ResponseEntity<SimpleDoctorDTO> findSimpleDoctorById(@PathVariable("doctor_id") String id) {
        return ResponseEntity.ok(doctorService.findSimpleDoctorById(id));
    }

    @PutMapping("/{doctor_id}/status")
    public ResponseEntity<SimpleDoctorDTO> updateDoctorStatusById(@RequestBody UpdateDoctorStatusDTO updateDoctorStatusDTO,
                                                                  @PathVariable("doctor_id") String id) {
        return ResponseEntity.ok(doctorService.updateDoctorStatus(updateDoctorStatusDTO, id));
    }

    @GetMapping("/{doctor_id}/specialities")
    public ResponseEntity<DoctorSpecialitiesDTO> findDoctorSpecialitiesById(@PathVariable("doctor_id") String id) {
        return ResponseEntity.ok(doctorService.findDoctorWithSpecialitiesById(id));
    }

}
