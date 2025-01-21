package student.informatics.medicalrecord.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student.informatics.medicalrecord.data.dto.appointment.DetailedAppointmentDTO;
import student.informatics.medicalrecord.data.dto.appointment.CreateAppointmentDTO;
import student.informatics.medicalrecord.data.dto.appointment.SimpleAppointmentDTO;
import student.informatics.medicalrecord.data.dto.appointment.UpdateAppointmentDTO;
import student.informatics.medicalrecord.service.AppointmentService;

import java.util.List;

@RequiredArgsConstructor

@CrossOrigin(origins = "http://localhost:8050")
@RestController
@RequestMapping("/api.medical-record/v1/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("/simple")
    public ResponseEntity<List<SimpleAppointmentDTO>> findAllSimpleAppointments() {
        return ResponseEntity.ok(appointmentService.findAllSimpleAppointments());
    }

    @GetMapping("/simple/{appointment_id}")
    public ResponseEntity<SimpleAppointmentDTO> findSimpleAppointmentById(@PathVariable("appointment_id") String id) {
        return ResponseEntity.ok(appointmentService.findSimpleAppointmentById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<SimpleAppointmentDTO> createAppointment(
            @RequestBody CreateAppointmentDTO createAppointmentDTO) {
        return ResponseEntity.ok(appointmentService.createAppointment(createAppointmentDTO));
    }

    @PutMapping("/{appointment_id}/update")
    public ResponseEntity<SimpleAppointmentDTO> updateAppointment(
            @RequestBody UpdateAppointmentDTO updateAppointmentDTO,
            @PathVariable("appointment_id") String id) {
        return ResponseEntity.ok(appointmentService.updateAppointment(updateAppointmentDTO, id));
    }

    @GetMapping("/simple/{doctor_id}/doctor")
    public ResponseEntity<List<SimpleAppointmentDTO>> findAllSimpleAppointmentsByDoctorId(@PathVariable("doctor_id") String id) {
        return ResponseEntity.ok(appointmentService.findAllSimpleAppointmentsByDoctorId(id));
    }

    @GetMapping("/simple/{patient_id}/patient")
    public ResponseEntity<List<SimpleAppointmentDTO>> findAllSimpleAppointmentsByPatientId(@PathVariable("patient_id") String id) {
        return ResponseEntity.ok(appointmentService.findAllSimpleAppointmentsByPatientId(id));
    }

    @GetMapping("/detailed/{appointment_id}")
    public ResponseEntity<DetailedAppointmentDTO> findDetailedAppointmentById(@PathVariable("appointment_id") String id) {
        return ResponseEntity.ok(appointmentService.findAppointmentDetailedById(id));
    }

}
