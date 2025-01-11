package student.informatics.medicalrecord.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import student.informatics.medicalrecord.data.dto.doc_specialities.CreateDoctorSpecialityDTO;
import student.informatics.medicalrecord.data.dto.doc_specialities.SimpleDoctorSpecialityDTO;
import student.informatics.medicalrecord.data.dto.doc_specialities.UpdateDoctorSpecialityDTO;
import student.informatics.medicalrecord.data.entity.Doctor;
import student.informatics.medicalrecord.data.entity.DoctorSpeciality;
import student.informatics.medicalrecord.data.repository.DoctorRepository;
import student.informatics.medicalrecord.data.repository.DoctorSpecialityRepository;
import student.informatics.medicalrecord.exception.DoctorSpecialityNotFoundException;
import student.informatics.medicalrecord.service.DoctorSpecialityService;
import student.informatics.medicalrecord.utility.ModelMapperUtil;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DoctorSpecialityServiceImpl implements DoctorSpecialityService {

    private final DoctorRepository doctorRepository;
    private final DoctorSpecialityRepository doctorSpecialityRepository;
    private final ModelMapperUtil modelMapperUtil;

    @Override
    public List<SimpleDoctorSpecialityDTO> findAllSimpleDoctorSpecialities() {
        return modelMapperUtil
                .mapList(doctorSpecialityRepository.findAll(), SimpleDoctorSpecialityDTO.class);
    }

    @Override
    public SimpleDoctorSpecialityDTO findSimpleSpecialityById(String id) {

        DoctorSpeciality doctorSpeciality = doctorSpecialityRepository.findById(id)
                .orElseThrow(() -> new DoctorSpecialityNotFoundException(String.format("DoctorSpeciality with ID '%s' not found", id)));

        return modelMapperUtil.map(doctorSpeciality, SimpleDoctorSpecialityDTO.class);
    }

    @Override
    public SimpleDoctorSpecialityDTO createDoctorSpeciality(CreateDoctorSpecialityDTO createDoctorSpecialityDTO) {

        DoctorSpeciality doctorSpeciality = DoctorSpeciality.builder()
                .name(createDoctorSpecialityDTO.getName())
                .description(createDoctorSpecialityDTO.getDescription())
                .build();

        return modelMapperUtil
                .map(doctorSpecialityRepository.save(doctorSpeciality), SimpleDoctorSpecialityDTO.class);
    }

    @Override
    public SimpleDoctorSpecialityDTO updateDoctorSpeciality(UpdateDoctorSpecialityDTO updateDoctorSpecialityDTO, String id) {

        DoctorSpeciality doctorSpeciality = doctorSpecialityRepository.findById(id)
                .orElseThrow(() -> new DoctorSpecialityNotFoundException(String.format("DoctorSpeciality with ID '%s' not found", id)));

        doctorSpeciality.setName(updateDoctorSpecialityDTO.getName());
        doctorSpeciality.setDescription(updateDoctorSpecialityDTO.getDescription());

        return modelMapperUtil
                .map(doctorSpecialityRepository.save(doctorSpeciality), SimpleDoctorSpecialityDTO.class);
    }

    @Override
    @Transactional
    public void deleteDoctorSpecialityById(String id) {

        DoctorSpeciality doctorSpeciality = doctorSpecialityRepository.findById(id)
                .orElseThrow(() -> new DoctorSpecialityNotFoundException(String.format("Doctor speciality with ID: '%s' not found", id)));

        List<Doctor> associatedDoctors = doctorRepository.findAllBySpecialitiesContaining(doctorSpeciality);

        associatedDoctors.forEach(doctor -> {
            doctor.getSpecialities().remove(doctorSpeciality);
            doctorRepository.save(doctor);
        });

        doctorSpecialityRepository.delete(doctorSpeciality);
    }
}
