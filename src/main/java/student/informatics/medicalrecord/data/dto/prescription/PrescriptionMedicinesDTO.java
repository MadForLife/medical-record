package student.informatics.medicalrecord.data.dto.prescription;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import student.informatics.medicalrecord.data.dto.medicine.SimpleMedicineDTO;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PrescriptionMedicinesDTO {

    private String id;
    private String description;
    private List<SimpleMedicineDTO> medicines;
}
