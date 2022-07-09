package repository.impl;

import players.Reception;
import repository.ReceptionRepository;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class ReceptionRepositoryImpl implements ReceptionRepository {

    private static final String FILE_NAME = "receptions.txt";
    private static final Set<Reception> RECEPTIONS = new HashSet<>();

    static {
        loadDataToFile();
    }

    private static final ReceptionRepositoryImpl SINGLETON = new ReceptionRepositoryImpl();


    private ReceptionRepositoryImpl() {
    }

    public static ReceptionRepository getSingleton() {
        return SINGLETON;
    }

    private static void saveDataToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            outputStream.writeObject(RECEPTIONS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadDataToFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Set<Reception> loadedReceptions = (Set<Reception>) inputStream.readObject();
            RECEPTIONS.addAll(loadedReceptions);
        } catch (FileNotFoundException e) {
            //
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<Reception> getReceptions() {
        return RECEPTIONS;
    }

    @Override
    public void save(Reception reception) {
        RECEPTIONS.add(reception);
        saveDataToFile();
    }

    @Override
    public void changeStatus(Reception reception, String status) {
        RECEPTIONS.remove(reception);
        reception.setStatus(status);
        RECEPTIONS.add(reception);
        saveDataToFile();
    }

    @Override
    public void remove(Reception reception) {
        RECEPTIONS.remove(reception);
        saveDataToFile();
    }

}
