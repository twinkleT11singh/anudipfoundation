package dao;


import model.Patient;
import java.util.List;

public interface PatientDao {
    void addPatient(Patient patient);
    Patient getPatientById(int id);
     List<Patient> getAllPatients();
    void updatePatient(Patient patient);
    void deletePatient(int id);
}

