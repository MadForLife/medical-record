package student.informatics.medicalrecord.data.dto.doctor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor
public class DetailedDoctorDTO extends SimpleDoctorDTO {

    private Set<String> patientIds;
    private Set<String> specialityIds;
    private Set<String> appointmentIds;

    public DetailedDoctorDTO(String id, String firstName, String lastName, Boolean isPersonalDoctor, Set<String> patientIds, Set<String> specialityIds, Set<String> appointmentIds) {
        super(id, firstName, lastName, isPersonalDoctor);
        this.patientIds = patientIds;
        this.specialityIds = specialityIds;
        this.appointmentIds = appointmentIds;
    }
}
