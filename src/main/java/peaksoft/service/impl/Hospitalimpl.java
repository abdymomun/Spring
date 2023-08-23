package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Hospital;
import peaksoft.repositories.HospitalRepo;
import peaksoft.service.HospitalService;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class Hospitalimpl implements HospitalService {
    private final HospitalRepo hospitalRepo;
    @Override
    public void saveHospital(Hospital hospital) {
hospitalRepo.save(hospital);
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return hospitalRepo.findAll();
    }

    @Override
    public Hospital getHospitalById(Long hospitalId) {
        return hospitalRepo.findById(hospitalId).orElseThrow(()->new NullPointerException("Hospital with if: "+ hospitalId +" not found !"));
    }

    @Override
    public void updateHospital(Long id, Hospital hospital) {
        Hospital hospital1 = getHospitalById(id);
        hospital1.setName(hospital.getName());
        hospital1.setAddress(hospital.getAddress());
    }

    @Override
    public void deleteHospital(Long id) {
hospitalRepo.deleteById(id);
    }
}
