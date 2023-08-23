package peaksoft.service;

import peaksoft.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    void saveAppointment(Appointment appointment,Long hospitalId,Long doctorId);
    Appointment getAppointmentById(Long appointmentId);
    List<Appointment> getAllAppointment(Long hospitalId);
    void updateAppointmentById(Long appointmentId,Appointment appointment);
    void deleteAppointment(Long appointmentId);
}
