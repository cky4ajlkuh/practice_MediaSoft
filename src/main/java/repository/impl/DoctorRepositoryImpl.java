package repository.impl;

import players.Doctor;
import repository.DoctorRepository;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class DoctorRepositoryImpl implements DoctorRepository {
    private static final String FILE_NAME = "doctors.txt";
    private static final Set<Doctor> DOCTORS = new HashSet<>();

    static {
        loadDataToFile();
    }

    private static final DoctorRepositoryImpl SINGLETON = new DoctorRepositoryImpl();

    private DoctorRepositoryImpl() {
    }

    public static DoctorRepository getSingleton() {
        return SINGLETON;
    }

    private static void saveDataToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            outputStream.writeObject(DOCTORS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadDataToFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Set<Doctor> loadedDoctors = (Set<Doctor>) inputStream.readObject();
            DOCTORS.addAll(loadedDoctors);
        } catch (FileNotFoundException e) {
            //
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<Doctor> getDoctors() {
        return DOCTORS;
    }

    @Override
    public void save(Doctor newDoctor) {
        DOCTORS.add(newDoctor);
        saveDataToFile();
    }

    @Override
    public void remove(Doctor doctor) {
        DOCTORS.remove(doctor);
        saveDataToFile();
    }
}
