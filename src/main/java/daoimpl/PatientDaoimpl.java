package daoimpl;

import dao.PatientDao;
import model.Patient;
import utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

public  class PatientDaoimpl implements PatientDao {
    @Override
    public void addPatient(Patient patient) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(patient);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Patient getPatientById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Patient.class, id);
        }
    }
    
    
    @Override
    public List<Patient> getAllPatients() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Patient", Patient.class).list();
        }
    }
    
    @Override
    public void updatePatient(Patient patient) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(patient);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePatient(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Patient patient = session.get(Patient.class, id);
            if (patient != null) {
                session.delete(patient);
            }
            transaction.commit();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
