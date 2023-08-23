package peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.entity.Department;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department,Long> {
    List<Department> findAllByHospitalId(Long hospitalId);

}
