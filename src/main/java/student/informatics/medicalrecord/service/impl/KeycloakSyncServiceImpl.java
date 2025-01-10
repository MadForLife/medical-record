package student.informatics.medicalrecord.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import student.informatics.medicalrecord.data.dto.KeycloakSyncModel;
import student.informatics.medicalrecord.data.entity.Doctor;
import student.informatics.medicalrecord.data.entity.Patient;
import student.informatics.medicalrecord.data.entity.User;
import student.informatics.medicalrecord.data.repository.DoctorRepository;
import student.informatics.medicalrecord.data.repository.PatientRepository;
import student.informatics.medicalrecord.data.repository.UserRepository;
import student.informatics.medicalrecord.exception.UserNotFoundException;

@RequiredArgsConstructor
@Service
public class KeycloakSyncServiceImpl {

    private final PatientRepository patientRepository;
    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;

    public User createUser(KeycloakSyncModel keycloakSyncModel) {

        Patient patient = new Patient();
        patient.setId(keycloakSyncModel.getId());
        patient.setFirstName(keycloakSyncModel.getFirstName());
        patient.setLastName(keycloakSyncModel.getLastName());
        patient.setUcn(keycloakSyncModel.getPersonalIdentificationNumber());
        patient.setIsHealthInsured(false);
        patient.setPersonalDoctor(null);

        return patientRepository.save(patient);
    }

    public User updateUser(KeycloakSyncModel keycloakSyncModel) {

        User user = userRepository.findById(keycloakSyncModel.getId())
                .orElseThrow(() -> new UserNotFoundException(String.format("User with ID '%s' not found", keycloakSyncModel.getId())));

        user.setFirstName(keycloakSyncModel.getFirstName());
        user.setLastName(keycloakSyncModel.getLastName());

        return userRepository.save(user);
    }

    public User createDoctor(KeycloakSyncModel keycloakSyncModel) {

        Doctor doctor = new Doctor();
        doctor.setId(keycloakSyncModel.getId());
        doctor.setFirstName(keycloakSyncModel.getFirstName());
        doctor.setLastName(keycloakSyncModel.getLastName());
        doctor.setIsPersonalDoctor(false);

        return doctorRepository.save(doctor);
    }
}
