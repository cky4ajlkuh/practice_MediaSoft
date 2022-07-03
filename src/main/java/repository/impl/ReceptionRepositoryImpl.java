package repository.impl;

import players.Reception;
import repository.ReceptionRepository;

import java.util.HashSet;
import java.util.Set;

public class ReceptionRepositoryImpl implements ReceptionRepository {

    private static final Set<Reception> RECEPTIONS = new HashSet<>();
    private static final ReceptionRepositoryImpl SINGLETON = new ReceptionRepositoryImpl();

    private ReceptionRepositoryImpl() {
    }

    public static ReceptionRepository getSingleton() {
        return SINGLETON;
    }

    @Override
    public Set<Reception> getReceptions() {
        return RECEPTIONS;
    }

    @Override
    public void save(Reception reception) {
        RECEPTIONS.add(reception);
    }

    @Override
    public void changeStatus(Reception reception, String status) {
        RECEPTIONS.remove(reception);
        reception.setStatus(status);
        RECEPTIONS.add(reception);
    }

}
