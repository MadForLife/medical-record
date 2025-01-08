package student.informatics.medicalrecord.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import student.informatics.medicalrecord.data.dto.medicine.CreateMedicineDTO;
import student.informatics.medicalrecord.data.dto.medicine.SimpleMedicineDTO;
import student.informatics.medicalrecord.data.dto.medicine.UpdateMedicineDTO;
import student.informatics.medicalrecord.data.entity.Medicine;
import student.informatics.medicalrecord.data.entity.Prescription;
import student.informatics.medicalrecord.data.repository.MedicineRepository;
import student.informatics.medicalrecord.data.repository.PrescriptionRepository;
import student.informatics.medicalrecord.exception.MedicineNotFoundException;
import student.informatics.medicalrecord.service.MedicineService;
import student.informatics.medicalrecord.utility.ModelMapperUtil;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;
    private final PrescriptionRepository prescriptionRepository;
    private final ModelMapperUtil modelMapperUtil;

    @Override
    public List<SimpleMedicineDTO> findAllSimpleMedicines() {
        return modelMapperUtil
                .mapList(medicineRepository.findAll(), SimpleMedicineDTO.class);
    }

    @Override
    public SimpleMedicineDTO findSimpleMedicineById(String id) {

        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new MedicineNotFoundException(String.format("Medicine with ID: '%s' not found", id)));

        return modelMapperUtil.map(medicine, SimpleMedicineDTO.class);
    }

    @Override
    public SimpleMedicineDTO createMedicine(CreateMedicineDTO createMedicineDTO) {

        Medicine medicine = Medicine.builder()
                .name(createMedicineDTO.getName())
                .description(createMedicineDTO.getDescription())
                .build();

        return modelMapperUtil.map(medicineRepository.save(medicine), SimpleMedicineDTO.class);
    }

    @Override
    public SimpleMedicineDTO updateMedicine(UpdateMedicineDTO updateMedicineDTO, String id) {

        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new MedicineNotFoundException(String.format("Medicine with ID: '%s' not found", id)));

        medicine.setName(updateMedicineDTO.getName());
        medicine.setDescription(updateMedicineDTO.getDescription());

        return modelMapperUtil.map(medicineRepository.save(medicine), SimpleMedicineDTO.class);
    }

    @Override
    @Transactional
    public void deleteMedicineById(String id) {

        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new MedicineNotFoundException(String.format("Medicine with ID: '%s' not found", id)));

        List<Prescription> associatedPrescriptions = prescriptionRepository.findAllByMedicinesContaining(medicine);

        associatedPrescriptions.forEach(prescription -> {
            prescription.getMedicines().remove(medicine);
            prescriptionRepository.save(prescription);
        });

        medicineRepository.delete(medicine);
    }
}
