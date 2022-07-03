package repository;

import players.Patient;

import java.util.Set;

public interface PatientRepository {

    Set<Patient> getPatients();

    void changeName(Patient patient, String name);

    void save(Patient patient);

    void remove(Patient patient);
}
