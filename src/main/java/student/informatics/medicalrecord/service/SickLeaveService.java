package student.informatics.medicalrecord.service;

import student.informatics.medicalrecord.data.dto.sick_leave.CreateSickLeaveDTO;
import student.informatics.medicalrecord.data.dto.sick_leave.SimpleSickLeaveDTO;
import student.informatics.medicalrecord.data.dto.sick_leave.UpdateSickLeaveDTO;

import java.util.List;

public interface SickLeaveService {

    List<SimpleSickLeaveDTO> findAllSimpleSickLeaves();

    SimpleSickLeaveDTO findSimpleSickLeaveById(String id);

    SimpleSickLeaveDTO updateSickLeave(UpdateSickLeaveDTO updateSickLeaveDTO, String id);

    SimpleSickLeaveDTO createSickLeave(CreateSickLeaveDTO createSickLeaveDTO);

}
