package student.informatics.medicalrecord.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DiagnoseCodeNotFoundException extends RuntimeException {
    public DiagnoseCodeNotFoundException(String message) {
        super(message);
    }
}
