package peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.entity.Hospital;

import java.util.List;

public interface HospitalRepo extends JpaRepository<Hospital,Long> {

}
