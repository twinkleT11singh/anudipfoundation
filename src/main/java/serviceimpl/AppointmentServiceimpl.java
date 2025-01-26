package serviceimpl;


import daoimpl.AppointmentDaoimpl;
import model.Appointment;
import service.AppointmentService;

import java.util.List;

import dao.AppointmentDao;

public  class AppointmentServiceimpl implements AppointmentService {
    private final AppointmentDao adao = new AppointmentDaoimpl();

    @Override
    public void addAppointment(Appointment appointment) {
        adao.addAppointment(appointment);
    }

    @Override
    public Appointment getAppointmentById(int id) {
        return adao.getAppointmentById(id);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return adao.getAllAppointments();
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        adao.updateAppointment(appointment);
    }

    @Override
    public void deleteAppointment(int id) {
        adao.deleteAppointment(id);
    }
}




