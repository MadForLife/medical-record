package student.informatics.medicalrecord.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import student.informatics.medicalrecord.data.dto.doctor.SimpleDoctorDTO;
import student.informatics.medicalrecord.data.dto.patient.SimplePatientDTO;
import student.informatics.medicalrecord.data.dto.patient.UpdatePatientDTO;
import student.informatics.medicalrecord.data.entity.Doctor;
import student.informatics.medicalrecord.data.entity.Patient;
import student.informatics.medicalrecord.data.repository.DoctorRepository;
import student.informatics.medicalrecord.data.repository.PatientRepository;
import student.informatics.medicalrecord.exception.DoctorNotFoundException;
import student.informatics.medicalrecord.exception.PatientNotFoundException;
import student.informatics.medicalrecord.service.PatientService;
import student.informatics.medicalrecord.utility.ModelMapperUtil;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final ModelMapperUtil modelMapperUtil;

    @Override
    public List<SimplePatientDTO> findAllSimplePatients() {
        return modelMapperUtil
                .mapList(patientRepository.findAll(), SimplePatientDTO.class);
    }

    @Override
    public SimplePatientDTO findSimplePatientById(String id) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(String.format("Patient with ID: '%s' not found", id)));

        SimpleDoctorDTO doctor = modelMapperUtil.map(patient.getPersonalDoctor(), SimpleDoctorDTO.class);

        SimplePatientDTO simplePatientDTO = new SimplePatientDTO();
        simplePatientDTO.setId(patient.getId());
        simplePatientDTO.setUcn(patient.getUcn());
        simplePatientDTO.setIsHealthInsured(patient.getIsHealthInsured());
        simplePatientDTO.setDoctor(doctor);

        return simplePatientDTO;
    }

    @Override
    public SimplePatientDTO updatePatient(UpdatePatientDTO updatePatientDTO, String id) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(String.format("Patient with ID: '%s' not found", id)));

        Doctor doctor = doctorRepository.findById(updatePatientDTO.getDoctorId())
                        .orElseThrow(() -> new DoctorNotFoundException(String.format("Doctor with ID: '%s' not found", id)));

        patient.setUcn(updatePatientDTO.getUcn());
        patient.setIsHealthInsured(updatePatientDTO.getIsHealthInsured());
        patient.setPersonalDoctor(doctor);

        return modelMapperUtil.map(patientRepository.save(patient), SimplePatientDTO.class);
    }

    @Override
    public List<SimplePatientDTO> findAllSimplePatientsByDoctorId(String id) {
        return modelMapperUtil
                .mapList(patientRepository.findByPersonalDoctorId(id), SimplePatientDTO.class);
    }

    @Override
    public List<SimplePatientDTO> findPatientsByDiagnosisCode(String diagnosisCode) {
        return modelMapperUtil
                .mapList(patientRepository.findPatientsByDiagnosisCode(diagnosisCode), SimplePatientDTO.class);
    }
}
