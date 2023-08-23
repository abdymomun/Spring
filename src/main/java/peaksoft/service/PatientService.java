package peaksoft.service;

import peaksoft.entity.Patient;

import java.util.List;

public interface PatientService {
    void savePatientToHospital(Patient patient,Long hospitalId);
    Patient getPatientById(Long Id);
    List<Patient> getAllPatient ();
    void updatePatientById(Long patientId,Patient patient);
    void deletePatient(Long id);

}
