package serviceimpl;


import daoimpl.DoctorDaoimpl;
import model.Doctor;
import service.DoctorService;

import java.util.List;

import dao.DoctorDao;

public  class DoctorServiceimpl implements DoctorService {
    private final  DoctorDao Ddao = new DoctorDaoimpl();

    @Override
    public void addDoctor(Doctor doctor) {
        Ddao.addDoctor(doctor);
    }

    @Override
    public Doctor getDoctorById(int id) {
        return Ddao.getDoctorById(id);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return Ddao.getAllDoctors();
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        Ddao.updateDoctor(doctor);
    }

    @Override
    public void deleteDoctor(int id) {
        Ddao.deleteDoctor(id);
    }
}

