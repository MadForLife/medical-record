package student.informatics.medicalrecord.service;

import student.informatics.medicalrecord.data.dto.doc_specialities.CreateDoctorSpecialityDTO;
import student.informatics.medicalrecord.data.dto.doc_specialities.SimpleDoctorSpecialityDTO;
import student.informatics.medicalrecord.data.dto.doc_specialities.UpdateDoctorSpecialityDTO;

import java.util.List;

public interface DoctorSpecialityService {

    List<SimpleDoctorSpecialityDTO> findAllSimpleDoctorSpecialities();
    SimpleDoctorSpecialityDTO findSimpleSpecialityById(String id);
    SimpleDoctorSpecialityDTO createDoctorSpeciality(CreateDoctorSpecialityDTO createDoctorSpecialityDTO);
    SimpleDoctorSpecialityDTO updateDoctorSpeciality(UpdateDoctorSpecialityDTO updateDoctorSpecialityDTO, String id);

    void deleteDoctorSpecialityById(String id);
}
