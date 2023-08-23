package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Department;
import peaksoft.entity.Hospital;
import peaksoft.repositories.DepartmentRepo;
import peaksoft.repositories.HospitalRepo;
import peaksoft.service.DepartmentService;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentImpl implements DepartmentService {
    private final DepartmentRepo departmentRepo;
    private final HospitalRepo hospitalRepo;

    @Override
    public void save(Department department, Long hospitalId) {
        Hospital hospital = hospitalRepo.findById(hospitalId).orElseThrow(() -> new NullPointerException("Hospital with id:" + hospitalId + " not found !"));
        department.setHospital(hospital);
        departmentRepo.save(department);
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepo.findById(departmentId).orElseThrow(() -> new NullPointerException("Department with id: " + departmentId + " not found !"));
    }

    @Override
    public List<Department> getAllDepartment(Long hospitalId) {
        Hospital hospital = hospitalRepo.findById(hospitalId).orElseThrow(() -> new NullPointerException("Hospital with id:" + hospitalId + " not found !"));
        return departmentRepo.findAllByHospitalId(hospital.getId());
    }

    @Override
    public void updateDepartmentById(Long departmentId, Department department) {
        Department department1 = departmentRepo.findById(departmentId).orElseThrow(() -> new NullPointerException("not found !"));
        department1.setName(department.getName());
        departmentRepo.save(department1);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        Department department = departmentRepo.findById(departmentId).orElseThrow(()->new NullPointerException("Department with id: "+ departmentId +" not found !"));
        Hospital hospital = department.getHospital();
        hospital.getDepartments().remove(department);
        departmentRepo.delete(department);

    }
}
