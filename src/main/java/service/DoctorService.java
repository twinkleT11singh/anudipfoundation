package service;


import model.Doctor;
import java.util.List;

public interface DoctorService {
    void addDoctor(Doctor doctor);
    Doctor getDoctorById(int id);
    List<Doctor> getAllDoctors();
    void updateDoctor(Doctor doctor);
    void deleteDoctor(int id);
}

