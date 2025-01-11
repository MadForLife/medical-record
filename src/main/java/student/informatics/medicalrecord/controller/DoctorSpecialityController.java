package student.informatics.medicalrecord.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student.informatics.medicalrecord.data.dto.doc_specialities.CreateDoctorSpecialityDTO;
import student.informatics.medicalrecord.data.dto.doc_specialities.SimpleDoctorSpecialityDTO;
import student.informatics.medicalrecord.data.dto.doc_specialities.UpdateDoctorSpecialityDTO;
import student.informatics.medicalrecord.service.DoctorSpecialityService;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api.medical-record/v1/doctor-specialities")
public class DoctorSpecialityController {

    private final DoctorSpecialityService doctorSpecialityService;

    @GetMapping("/simple")
    public ResponseEntity<List<SimpleDoctorSpecialityDTO>> findAllSimpleSpecialities() {
        return ResponseEntity.ok(doctorSpecialityService.findAllSimpleDoctorSpecialities());
    }

    @GetMapping("/simple/{speciality_id}")
    public ResponseEntity<SimpleDoctorSpecialityDTO> findSimpleSpecialityById(
            @PathVariable("speciality_id") String id) {
        return ResponseEntity.ok(doctorSpecialityService.findSimpleSpecialityById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<SimpleDoctorSpecialityDTO> createDoctorSpeciality(
            @RequestBody CreateDoctorSpecialityDTO dto) {
        return ResponseEntity.ok(doctorSpecialityService.createDoctorSpeciality(dto));
    }

    @PutMapping("/{speciality_id}/update")
    public ResponseEntity<SimpleDoctorSpecialityDTO> updateDoctorSpeciality(
            @RequestBody UpdateDoctorSpecialityDTO dto,
            @PathVariable("speciality_id") String id) {
        return ResponseEntity.ok(doctorSpecialityService.updateDoctorSpeciality(dto, id));
    }

    @DeleteMapping("/{speciality_id}/delete")
    public ResponseEntity<Void> deleteDoctorSpeciality(@PathVariable("speciality_id") String id) {
        doctorSpecialityService.deleteDoctorSpecialityById(id);
        return ResponseEntity.noContent().build();
    }
}