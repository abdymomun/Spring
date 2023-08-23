package peaksoft.service;

import peaksoft.entity.Department;

import java.util.List;

public interface DepartmentService {
void save(Department department, Long  hospitalId);
Department getDepartmentById(Long departmentId);
List<Department> getAllDepartment(Long hospitalId);
void updateDepartmentById(Long departmentId, Department department);
void deleteDepartmentById(Long departmentId);

}
