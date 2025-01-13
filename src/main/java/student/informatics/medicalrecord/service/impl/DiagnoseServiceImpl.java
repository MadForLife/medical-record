package student.informatics.medicalrecord.service.impl;

import jdk.jshell.Diag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import student.informatics.medicalrecord.data.dto.diagnose.CreateDiagnoseDTO;
import student.informatics.medicalrecord.data.dto.diagnose.SimpleDiagnoseDTO;
import student.informatics.medicalrecord.data.dto.diagnose.UpdateDiagnoseDTO;
import student.informatics.medicalrecord.data.entity.Appointment;
import student.informatics.medicalrecord.data.entity.Diagnose;
import student.informatics.medicalrecord.data.entity.DiagnoseCode;
import student.informatics.medicalrecord.data.repository.AppointmentRepository;
import student.informatics.medicalrecord.data.repository.DiagnoseCodeRepository;
import student.informatics.medicalrecord.data.repository.DiagnoseRepository;
import student.informatics.medicalrecord.exception.AppointmentNotFoundException;
import student.informatics.medicalrecord.exception.DiagnoseNotFoundException;
import student.informatics.medicalrecord.service.DiagnoseService;
import student.informatics.medicalrecord.utility.ModelMapperUtil;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DiagnoseServiceImpl implements DiagnoseService {

    private final DiagnoseRepository diagnoseRepository;
    private final DiagnoseCodeRepository diagnoseCodeRepository;
    private final AppointmentRepository appointmentRepository;
    private final ModelMapperUtil modelMapperUtil;

    @Override
    public List<SimpleDiagnoseDTO> findAllSimpleDiagnoses() {
        return modelMapperUtil
                .mapList(diagnoseRepository.findAll(), SimpleDiagnoseDTO.class);
    }

    @Override
    public SimpleDiagnoseDTO findSimpleDiagnoseById(String id) {

        Diagnose diagnose = diagnoseRepository.findById(id)
                .orElseThrow(() -> new DiagnoseNotFoundException(String.format("Diagnose with ID: '%s' not found", id)));

        return modelMapperUtil.map(diagnose, SimpleDiagnoseDTO.class);
    }

    @Override
    public SimpleDiagnoseDTO createDiagnose(CreateDiagnoseDTO createDiagnoseDTO) {

        Appointment appointment = findAppointmentById(createDiagnoseDTO.getAppointmentId());
        DiagnoseCode diagnoseCode = findDiagnoseCodeById(createDiagnoseDTO.getDiagnoseCodeId());

        Diagnose diagnose = new Diagnose();
        diagnose.setAppointment(appointment);
        diagnose.setDiagnoseCode(diagnoseCode);
        diagnose.setDescription(createDiagnoseDTO.getDescription());

        return modelMapperUtil.map(diagnoseRepository.save(diagnose), SimpleDiagnoseDTO.class);
    }

    @Override
    public SimpleDiagnoseDTO updateDiagnose(UpdateDiagnoseDTO updateDiagnoseDTO, String id) {

        Appointment appointment = findAppointmentById(updateDiagnoseDTO.getAppointmentId());
        DiagnoseCode diagnoseCode = findDiagnoseCodeById(updateDiagnoseDTO.getDiagnoseCodeId());

        Diagnose diagnose = diagnoseRepository.findById(id)
                .orElseThrow(() -> new DiagnoseNotFoundException(String.format("Diagnose with ID: '%s' not found", id)));

        diagnose.setAppointment(appointment);
        diagnose.setDiagnoseCode(diagnoseCode);
        diagnose.setDescription(updateDiagnoseDTO.getDescription());

        return modelMapperUtil.map(diagnoseRepository.save(diagnose), SimpleDiagnoseDTO.class);
    }

    private Appointment findAppointmentById(String appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotFoundException(String.format("Appointment: '%s' not found", appointmentId)));
    }

    private DiagnoseCode findDiagnoseCodeById(String diagnoseCodeId) {
        return diagnoseCodeRepository.findById(diagnoseCodeId)
                .orElseThrow(() -> new DiagnoseNotFoundException(String.format("Diagnose with ID: '%s' not found", diagnoseCodeId)));
    }
}
