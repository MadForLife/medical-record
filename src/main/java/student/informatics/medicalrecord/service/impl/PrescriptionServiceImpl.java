package student.informatics.medicalrecord.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import student.informatics.medicalrecord.data.dto.medicine.MedicineIdsRequestDTO;
import student.informatics.medicalrecord.data.dto.medicine.SimpleMedicineDTO;
import student.informatics.medicalrecord.data.dto.prescription.CreatePrescriptionDTO;
import student.informatics.medicalrecord.data.dto.prescription.PrescriptionMedicinesDTO;
import student.informatics.medicalrecord.data.dto.prescription.SimplePrescriptionDTO;
import student.informatics.medicalrecord.data.dto.prescription.UpdatePrescriptionDTO;
import student.informatics.medicalrecord.data.entity.Appointment;
import student.informatics.medicalrecord.data.entity.Medicine;
import student.informatics.medicalrecord.data.entity.Prescription;
import student.informatics.medicalrecord.data.repository.AppointmentRepository;
import student.informatics.medicalrecord.data.repository.MedicineRepository;
import student.informatics.medicalrecord.data.repository.PrescriptionRepository;
import student.informatics.medicalrecord.exception.AppointmentNotFoundException;
import student.informatics.medicalrecord.exception.PrescriptionNotFoundException;
import student.informatics.medicalrecord.service.PrescriptionService;
import student.informatics.medicalrecord.utility.ModelMapperUtil;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final AppointmentRepository appointmentRepository;
    private final MedicineRepository medicineRepository;
    private final ModelMapperUtil modelMapperUtil;

    @Override
    public List<SimplePrescriptionDTO> findAllSimplePrescriptions() {
        return modelMapperUtil
                .mapList(prescriptionRepository.findAll(), SimplePrescriptionDTO.class);
    }

    @Override
    public SimplePrescriptionDTO findSimplePrescriptionById(String id) {

        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new PrescriptionNotFoundException(String.format("Prescription with ID: '%s' not found", id)));

        return modelMapperUtil.map(prescription, SimplePrescriptionDTO.class);
    }

    @Override
    public SimplePrescriptionDTO createPrescription(CreatePrescriptionDTO createPrescriptionDTO) {

        String appointmentId = createPrescriptionDTO.getAppointmentId();
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotFoundException(String.format("Appointment: '%s' not found", appointmentId)));

        Prescription prescription = new Prescription();
        prescription.setDescription(createPrescriptionDTO.getDescription());
        prescription.setAppointment(appointment);

        return modelMapperUtil.map(prescriptionRepository.save(prescription), SimplePrescriptionDTO.class);
    }

    @Override
    public SimplePrescriptionDTO updatePrescription(UpdatePrescriptionDTO updatePrescriptionDTO, String id) {

        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new PrescriptionNotFoundException(String.format("Prescription with ID: '%s' not found", id)));


        String appointmentId = updatePrescriptionDTO.getAppointmentId();
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotFoundException(String.format("Appointment: '%s' not found", appointmentId)));

        prescription.setDescription(updatePrescriptionDTO.getDescription());
        prescription.setAppointment(appointment);

        return modelMapperUtil.map(prescriptionRepository.save(prescription), SimplePrescriptionDTO.class);

    }

    @Override
    public PrescriptionMedicinesDTO addMedicinesToPrescription(MedicineIdsRequestDTO medicinesId, String prescriptionId) {

        Prescription prescription = prescriptionRepository.findById(prescriptionId)
                .orElseThrow(() -> new PrescriptionNotFoundException(String.format("Prescription with ID: '%s' not found", prescriptionId)));

        List<Medicine> medicines = medicineRepository.findAllById(medicinesId.getMedicineIds());


        List<SimpleMedicineDTO> prescriptionMedicinesDTOS = modelMapperUtil
                .mapList(medicines, SimpleMedicineDTO.class);

        prescription.getMedicines().addAll(medicines);

        PrescriptionMedicinesDTO prescriptionMedicinesDTO = new PrescriptionMedicinesDTO();
        prescriptionMedicinesDTO.setId(prescription.getId());
        prescriptionMedicinesDTO.setDescription(prescription.getDescription());
        prescriptionMedicinesDTO.setMedicines(prescriptionMedicinesDTOS);

        prescriptionRepository.save(prescription);
        return prescriptionMedicinesDTO;
    }
}
