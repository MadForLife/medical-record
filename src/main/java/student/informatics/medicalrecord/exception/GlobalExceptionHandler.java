package student.informatics.medicalrecord.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // TODO Return type, why Object?
    @ExceptionHandler(DoctorSpecialityNotFoundException.class)
    public ResponseEntity<Object> handleDoctorSpecialityNotFoundException(DoctorSpecialityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(MedicineNotFoundException.class)
    public ResponseEntity<Object> handleMedicineNotFoundException(MedicineNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(DiagnoseCodeNotFoundException.class)
    public ResponseEntity<Object> handleDiagnoseCodeNotFoundException(DiagnoseCodeNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<Object> handleDoctorNotFoundException(DoctorNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Object> handlePatientNotFoundException(PatientNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(AppointmentNotFoundException.class)
    public ResponseEntity<Object> handleAppointmentNotFoundException(AppointmentNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(SickLeaveNotFoundException.class)
    public ResponseEntity<Object> handleSickLeaveNotFoundException(SickLeaveNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
