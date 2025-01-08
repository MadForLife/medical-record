package student.informatics.medicalrecord.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import student.informatics.medicalrecord.data.dto.doctor.SimpleDoctorDTO;
import student.informatics.medicalrecord.data.dto.doctor.UpdateDoctorStatusDTO;
import student.informatics.medicalrecord.data.entity.Doctor;
import student.informatics.medicalrecord.data.repository.DoctorRepository;
import student.informatics.medicalrecord.service.DoctorService;
import student.informatics.medicalrecord.utility.ModelMapperUtil;

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

    // FIXME Create a custom exception
    @Override
    public SimpleDoctorDTO findSimpleDoctorById(String id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(RuntimeException::new);
        return modelMapperUtil.map(doctor, SimpleDoctorDTO.class);
    }

    // FIXME Create a custom exception
    // FIXME Another possible variant (if resource is not found create it)
    @Override
    public SimpleDoctorDTO updateDoctorStatus(UpdateDoctorStatusDTO doctorStatusDTO, String id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(RuntimeException::new);
        doctor.setIsPersonalDoctor(doctorStatusDTO.getIsPersonalDoctor());
        return modelMapperUtil.map(doctorRepository.save(doctor), SimpleDoctorDTO.class);
    }

    // TODO Create Doctor [Use keycloak event listener to sync information]
    // TODO Delete Doctor [Use keycloak event listener to sync information]

}
