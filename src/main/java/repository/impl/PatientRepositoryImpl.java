package repository.impl;

import players.Patient;
import repository.PatientRepository;

import java.util.HashSet;
import java.util.Set;

public class PatientRepositoryImpl implements PatientRepository {

    private static final Set<Patient> PATIENTS = new HashSet<>();
    private static final PatientRepositoryImpl SINGLETON = new PatientRepositoryImpl();

    private PatientRepositoryImpl() {
    }

    public static PatientRepository getSingleton() {
        return SINGLETON;
    }

    @Override
    public void save(Patient patient) {
        PATIENTS.add(patient);
    }

    @Override
    public void remove(Patient patient) {
        PATIENTS.remove(patient);
    }

    @Override
    public Set<Patient> getPatients() {
        return PATIENTS;
    }

    @Override
    public void changeName(Patient patient, String name) {
        PATIENTS.remove(patient);
        patient.setName(name);
        PATIENTS.add(patient);
    }
}
