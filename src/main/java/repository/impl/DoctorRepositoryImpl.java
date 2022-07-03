package repository.impl;

import players.Doctor;
import repository.DoctorRepository;

import java.util.HashSet;
import java.util.Set;

public class DoctorRepositoryImpl implements DoctorRepository {
    private static final Set<Doctor> DOCTORS = new HashSet<>();
    private static final DoctorRepositoryImpl SINGLETON = new DoctorRepositoryImpl();

    private DoctorRepositoryImpl() {
    }

    public static DoctorRepository getSingleton() {
        return SINGLETON;
    }

    @Override
    public Set<Doctor> getDoctors() {
        return DOCTORS;
    }

    @Override
    public void save(Doctor newDoctor) {
        DOCTORS.add(newDoctor);
    }
}
