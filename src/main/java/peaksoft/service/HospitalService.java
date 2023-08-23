package peaksoft.service;

import peaksoft.entity.Hospital;

import java.util.List;

public interface HospitalService {
    void saveHospital (Hospital hospital);
    List<Hospital> getAllHospitals();
    Hospital getHospitalById(Long id);
    void updateHospital(Long id,Hospital hospital);
    void deleteHospital(Long id);
}
