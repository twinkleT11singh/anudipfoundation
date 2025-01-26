package serviceimpl;


import daoimpl.PatientDaoimpl;
import model.Patient;
import service.PatientService;

import java.util.List;

import dao.PatientDao;

public  class PatientServiceimpl implements PatientService {
    private final  PatientDao pdao = new PatientDaoimpl();

    @Override
    public void addPatient(Patient patient) {
        pdao.addPatient(patient);
    }

    @Override
    public Patient getPatientById(int id) {
        return pdao.getPatientById(id);
    }

    @Override
    public List<Patient> getAllPatients() {
        return pdao.getAllPatients();
    }

    @Override
    public void updatePatient(Patient patient) {
        pdao.updatePatient(patient);
    }

    @Override
    public void deletePatient(int id) {
        pdao.deletePatient(id);
    }
}
