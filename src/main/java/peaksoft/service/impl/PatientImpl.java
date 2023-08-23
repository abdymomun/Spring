package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Hospital;
import peaksoft.entity.Patient;
import peaksoft.repositories.HospitalRepo;
import peaksoft.repositories.PatientRepo;
import peaksoft.service.PatientService;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class PatientImpl implements PatientService {
    private final PatientRepo patientRepo;
    private final HospitalRepo hospitalRepo;
    @Override
    public void savePatientToHospital(Patient patient, Long hospitalId) {
        Hospital hospital = hospitalRepo.findById(hospitalId).orElseThrow(() -> new NullPointerException("Hospital with if: " + hospitalId + " not found !"));
        patient.setHospital(hospital);
        patientRepo.save(patient);
    }

    @Override
    public Patient getPatientById(Long Id) {
        return patientRepo.findById(Id)
                .orElseThrow(()->new NullPointerException("Patient with id: " + Id + " not found !"));
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientRepo.findAll();
    }

    @Override
    public void updatePatientById(Long patientId, Patient patient) {
        Patient patient1= getPatientById(patientId);
        patient1.setFirstName(patient.getFirstName());
        patient1.setLastName(patient.getLastName());
        patient1.setEmail(patient.getEmail());
        patient1.setPhoneNumber(patient.getPhoneNumber());
        patient1.setGender(patient.getGender());
        patientRepo.save(patient1);
    }

    @Override
    public void deletePatient(Long id) {
patientRepo.deleteById(id);
    }
}
