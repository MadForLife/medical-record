package student.informatics.medicalrecord.service;

import student.informatics.medicalrecord.data.dto.medicine.CreateMedicineDTO;
import student.informatics.medicalrecord.data.dto.medicine.SimpleMedicineDTO;
import student.informatics.medicalrecord.data.dto.medicine.UpdateMedicineDTO;

import java.util.List;

public interface MedicineService {

    List<SimpleMedicineDTO> findAllSimpleMedicines();
    SimpleMedicineDTO findSimpleMedicineById(String id);
    SimpleMedicineDTO createMedicine(CreateMedicineDTO createMedicineDTO);
    SimpleMedicineDTO updateMedicine(UpdateMedicineDTO updateMedicineDTO, String id);
    void deleteMedicineById(String id);
}
