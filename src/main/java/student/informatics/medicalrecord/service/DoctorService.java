package student.informatics.medicalrecord.service;

import student.informatics.medicalrecord.data.dto.doctor.DoctorSpecialitiesDTO;
import student.informatics.medicalrecord.data.dto.doctor.SimpleDoctorDTO;
import student.informatics.medicalrecord.data.dto.doctor.UpdateDoctorStatusDTO;

import java.util.List;

public interface DoctorService {

    List<SimpleDoctorDTO> findAllSimpleDoctors();

    SimpleDoctorDTO findSimpleDoctorById(String id);

    SimpleDoctorDTO updateDoctorStatus(UpdateDoctorStatusDTO doctorStatusDTO, String id);

    DoctorSpecialitiesDTO findDoctorWithSpecialitiesById(String id);

}
