package student.informatics.medicalrecord.data.dto.doctor;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import student.informatics.medicalrecord.data.dto.doc_specialities.SimpleDoctorSpecialityDTO;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorSpecialitiesDTO extends SimpleDoctorDTO {

    private List<SimpleDoctorSpecialityDTO> doctorSpecialities;
}
