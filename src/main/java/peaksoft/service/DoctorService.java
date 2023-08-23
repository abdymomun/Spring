package peaksoft.service;

import peaksoft.entity.Doctor;

import java.util.List;

public interface DoctorService {
    void saveDoctor(Doctor doctor,Long hospitalId,Long departmentId);
    void assignDoctorToDepartment(Long doctorId,Long departmentId);
    Doctor getDoctorById(Long hospitalId);
    List<Doctor> getAllDoctors(Long hospitalId);
    void updateDoctorById(Long DoctorId,Doctor doctor);
    void deleteDoctorById(Long Doctorid);
}
