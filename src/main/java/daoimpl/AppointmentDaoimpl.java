package daoimpl;


import dao.AppointmentDao;
import model.Appointment;
import utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public  class AppointmentDaoimpl implements AppointmentDao {
    @Override
    public void addAppointment(Appointment appointment) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(appointment);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Appointment getAppointmentById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Appointment.class, id);
        }
    }

    @Override
    public List<Appointment> getAllAppointments() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Appointment",Appointment.class).list();
        }
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(appointment);
            transaction.commit();
        } catch (Exception e) {
     e.printStackTrace();
        }
    }

    @Override
    public void deleteAppointment(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Appointment appointment = session.get(Appointment.class, id);
            if (appointment != null) {
                session.delete(appointment);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
