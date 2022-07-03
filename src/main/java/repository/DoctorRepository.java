package repository;

import players.Doctor;

import java.util.Set;

public interface DoctorRepository {
    Set<Doctor> getDoctors();

    void save(Doctor doctor);
}
