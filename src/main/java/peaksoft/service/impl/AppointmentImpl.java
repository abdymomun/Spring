package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Appointment;
import peaksoft.entity.Doctor;
import peaksoft.entity.Hospital;
import peaksoft.repositories.AppointmentRepo;
import peaksoft.repositories.DoctorRepo;
import peaksoft.repositories.HospitalRepo;
import peaksoft.service.AppointmentService;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class AppointmentImpl implements AppointmentService {
   private final AppointmentRepo appointmentRepo;
   private final HospitalRepo hospitalRepo;
   private final DoctorRepo doctorRepo;
    @Override
    public void saveAppointment(Appointment appointment, Long hospitalId,Long doctorId) {
        Hospital hospital = hospitalRepo.findById(hospitalId).orElseThrow(() -> new NullPointerException("Hospital with id:" + hospitalId + " not found !"));
        Doctor doctor = doctorRepo.findById(doctorId).orElseThrow(()->new NullPointerException("Doctor with id: + " +doctorId +" not found !"));
        hospital.setAppointments(List.of(appointment));
        appointment.setDoctor(doctor);
        appointmentRepo.save(appointment);}

    @Override
    public Appointment getAppointmentById(Long appointmentId) {
        return appointmentRepo.findById(appointmentId).orElseThrow(
                ()->new NullPointerException("Appointment with id: " +appointmentId+" not found !"));

    }

    @Override
    public List<Appointment> getAllAppointment(Long hospitalId) {
        Hospital hospital = hospitalRepo.findById(hospitalId).orElseThrow(() -> new NullPointerException("Hospital with id:" + hospitalId + " not found !"));
        return appointmentRepo.getAllApointment(hospital.getId());
    }

    @Override
    public void updateAppointmentById(Long appointmentId,Appointment appointment) {
        Appointment appointment1 = getAppointmentById(appointmentId);
        appointment1.setDate(appointment.getDate());
        appointmentRepo.save(appointment1);
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
if (appointmentRepo.existsById(appointmentId)){
    appointmentRepo.deleteById(appointmentId);
}else throw new NullPointerException("Appointment with id: " + appointmentId+" not found !");
    }
}
