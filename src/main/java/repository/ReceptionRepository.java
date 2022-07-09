package repository;

import players.Reception;

import java.util.Set;

public interface ReceptionRepository {
    Set<Reception> getReceptions();

    void save(Reception reception);

    void changeStatus(Reception reception, String status);

    void remove(Reception reception);
}
