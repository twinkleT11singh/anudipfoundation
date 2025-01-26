package dao;


import model.Appointment;
import java.util.List;

public interface AppointmentDao {
    void addAppointment(Appointment appointment);
    Appointment getAppointmentById(int id);
    List<Appointment> getAllAppointments();
    void updateAppointment(Appointment appointment);
    void deleteAppointment(int id);
}


