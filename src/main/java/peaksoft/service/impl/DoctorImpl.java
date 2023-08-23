package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Department;
import peaksoft.entity.Doctor;
import peaksoft.entity.Hospital;
import peaksoft.repositories.DepartmentRepo;
import peaksoft.repositories.DoctorRepo;
import peaksoft.repositories.HospitalRepo;
import peaksoft.service.DoctorService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DoctorImpl implements DoctorService {
    private final DoctorRepo doctorRepo;
    private final HospitalRepo hospitalRepo;
    private final DepartmentRepo departmentRepo;
    @Override
    public void saveDoctor(Doctor doctor ,Long hospitalId,Long departmentId) {
        Hospital hospital = hospitalRepo.findById(hospitalId).orElseThrow(()->new NullPointerException("Hospital with id:" + hospitalId +" not found !"));
        Department department = departmentRepo.findById(departmentId).orElseThrow(() -> new NullPointerException("Department with id: " + departmentId + " not found !"));
        doctor.setHospital(hospital);
        doctor.setDepartments(List.of(department));
        department.setDoctors(List.of(doctor));
        doctorRepo.save(doctor);

    }

    @Override
    public void assignDoctorToDepartment(Long doctorId, Long departmentId) {

    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepo.findById(id).orElseThrow(()->new NullPointerException("Doctor with id: + " +id +" not found !"));
    }

    @Override
    public List<Doctor> getAllDoctors(Long hospitalId) {
        return doctorRepo.findAll();
    }

    @Override
    public void updateDoctorById(Long DoctorId, Doctor doctor) {
        Doctor doctor1 = getDoctorById(DoctorId);
        doctor1.setFirstName(doctor.getFirstName());
        doctor1.setLastName(doctor.getLastName());
        doctor1.setEmail(doctor.getEmail());
        doctor1.setPosition(doctor.getPosition());
        doctorRepo.save(doctor1);
    }


    @Override
    public void deleteDoctorById(Long Doctorid) {
doctorRepo.deleteById(Doctorid);
    }
}
