package student.informatics.medicalrecord.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import student.informatics.medicalrecord.data.dto.doc_specialities.SimpleDoctorSpecialityDTO;
import student.informatics.medicalrecord.data.dto.doctor.DoctorSpecialitiesDTO;
import student.informatics.medicalrecord.data.dto.doctor.SimpleDoctorDTO;
import student.informatics.medicalrecord.data.dto.doctor.UpdateDoctorStatusDTO;
import student.informatics.medicalrecord.data.entity.Doctor;
import student.informatics.medicalrecord.data.repository.DoctorRepository;
import student.informatics.medicalrecord.exception.DoctorNotFoundException;
import student.informatics.medicalrecord.service.DoctorService;
import student.informatics.medicalrecord.utility.ModelMapperUtil;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final ModelMapperUtil modelMapperUtil;

    @Override
    public List<SimpleDoctorDTO> findAllSimpleDoctors() {
        return modelMapperUtil
                .mapList(doctorRepository.findAll(), SimpleDoctorDTO.class);
    }

    @Override
    public SimpleDoctorDTO findSimpleDoctorById(String id) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException(String.format("Doctor with ID: '%s' not found", id)));

        return modelMapperUtil.map(doctor, SimpleDoctorDTO.class);
    }

    @Override
    public SimpleDoctorDTO updateDoctorStatus(UpdateDoctorStatusDTO doctorStatusDTO, String id) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException(String.format("Doctor with ID: '%s' not found", id)));

        doctor.setIsPersonalDoctor(doctorStatusDTO.getIsPersonalDoctor());
        return modelMapperUtil.map(doctorRepository.save(doctor), SimpleDoctorDTO.class);
    }

    @Override
    public DoctorSpecialitiesDTO findDoctorWithSpecialitiesById(String id) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException(String.format("Doctor with ID: '%s' not found", id)));

        List<SimpleDoctorSpecialityDTO> specialities =
                modelMapperUtil.mapList(
                        new ArrayList<>(doctor.getSpecialities()), SimpleDoctorSpecialityDTO.class);

        DoctorSpecialitiesDTO doctorSpecialitiesDTO = new DoctorSpecialitiesDTO();
        doctorSpecialitiesDTO.setId(id);
        doctorSpecialitiesDTO.setFirstName(doctor.getFirstName());
        doctorSpecialitiesDTO.setLastName(doctor.getLastName());
        doctorSpecialitiesDTO.setIsPersonalDoctor(doctor.getIsPersonalDoctor());
        doctorSpecialitiesDTO.setDoctorSpecialities(specialities);

        return doctorSpecialitiesDTO;
    }

    // TODO Add UpdateDoctorSpecialities
}
