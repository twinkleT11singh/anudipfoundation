package dao;


import model.Doctor;
import java.util.List;

public interface DoctorDao {
    void addDoctor(Doctor doctor);
    Doctor getDoctorById(int id);
    List<Doctor> getAllDoctors();
    void updateDoctor(Doctor doctor);
    void deleteDoctor(int id);
}

