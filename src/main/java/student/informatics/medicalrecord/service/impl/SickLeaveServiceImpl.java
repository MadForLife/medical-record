package student.informatics.medicalrecord.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import student.informatics.medicalrecord.data.dto.sick_leave.CreateSickLeaveDTO;
import student.informatics.medicalrecord.data.dto.sick_leave.SimpleSickLeaveDTO;
import student.informatics.medicalrecord.data.dto.sick_leave.UpdateSickLeaveDTO;
import student.informatics.medicalrecord.data.entity.Appointment;
import student.informatics.medicalrecord.data.entity.SickLeave;
import student.informatics.medicalrecord.data.repository.AppointmentRepository;
import student.informatics.medicalrecord.data.repository.SickLeaveRepository;
import student.informatics.medicalrecord.exception.AppointmentNotFoundException;
import student.informatics.medicalrecord.exception.SickLeaveNotFoundException;
import student.informatics.medicalrecord.service.SickLeaveService;
import student.informatics.medicalrecord.utility.ModelMapperUtil;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SickLeaveServiceImpl implements SickLeaveService {

    private final SickLeaveRepository sickLeaveRepository;
    private final AppointmentRepository appointmentRepository;
    private final ModelMapperUtil modelMapperUtil;

    @Override
    public List<SimpleSickLeaveDTO> findAllSimpleSickLeaves() {
        return modelMapperUtil
                .mapList(sickLeaveRepository.findAll(), SimpleSickLeaveDTO.class);
    }

    @Override
    public SimpleSickLeaveDTO findSimpleSickLeaveById(String id) {

        SickLeave sickLeave = sickLeaveRepository.findById(id)
                .orElseThrow(() -> new SickLeaveNotFoundException(String.format("Sick leave with ID: '%s' not found", id)));

        return modelMapperUtil.map(sickLeave, SimpleSickLeaveDTO.class);
    }

    @Override
    public SimpleSickLeaveDTO updateSickLeave(UpdateSickLeaveDTO updateSickLeaveDTO, String id) {

        SickLeave sickLeave = sickLeaveRepository.findById(id)
                .orElseThrow(() -> new SickLeaveNotFoundException(String.format("Sick leave with ID: '%s' not found", id)));

        Appointment appointment = appointmentRepository.findById(sickLeave.getAppointment().getId())
                        .orElseThrow(() -> new AppointmentNotFoundException(String.format("Appointment with ID: '%s' not found",
                                sickLeave.getAppointment().getId())));
        
        sickLeave.setReason(updateSickLeaveDTO.getReason());
        sickLeave.setStartDate(updateSickLeaveDTO.getStartDate());
        sickLeave.setEndDate(updateSickLeaveDTO.getEndDate());
        sickLeave.setAppointment(appointment);

        return modelMapperUtil.map(sickLeaveRepository.save(sickLeave), SimpleSickLeaveDTO.class);
    }

    @Override
    public SimpleSickLeaveDTO createSickLeave(CreateSickLeaveDTO createSickLeaveDTO) {

        String appointmentId = createSickLeaveDTO.getAppointmentId();
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotFoundException(String.format("Appointment with ID: '%s' not found", appointmentId)));

        SickLeave sickLeave = new SickLeave();
        sickLeave.setReason(createSickLeaveDTO.getReason());
        sickLeave.setStartDate(createSickLeaveDTO.getStartDate());
        sickLeave.setEndDate(createSickLeaveDTO.getEndDate());
        sickLeave.setAppointment(appointment);

        return modelMapperUtil.map(sickLeaveRepository.save(sickLeave), SimpleSickLeaveDTO.class);
    }
}
