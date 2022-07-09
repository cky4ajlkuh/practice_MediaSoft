package repository.impl;

import players.Patient;
import repository.PatientRepository;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class PatientRepositoryImpl implements PatientRepository {

    private static final String FILE_NAME = "patients.txt";
    private static final Set<Patient> PATIENTS = new HashSet<>();

    static {
        loadDataToFile();
    }

    private static final PatientRepositoryImpl SINGLETON = new PatientRepositoryImpl();

    private PatientRepositoryImpl() {
    }

    public static PatientRepository getSingleton() {
        return SINGLETON;
    }

    private static void saveDataToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            outputStream.writeObject(PATIENTS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadDataToFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Set<Patient> loadedPatients = (Set<Patient>) inputStream.readObject();
            PATIENTS.addAll(loadedPatients);
        } catch (FileNotFoundException e) {
            //
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Patient patient) {
        PATIENTS.add(patient);
        saveDataToFile();
    }

    @Override
    public void remove(Patient patient) {
        PATIENTS.remove(patient);
        saveDataToFile();
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
