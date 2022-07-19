package repository.impl;

import config.ApplicationDataSource;
import lombok.SneakyThrows;
import players.Reception;
import repository.ReceptionRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ReceptionRepositoryImpl implements ReceptionRepository {

    private static final ReceptionRepositoryImpl SINGLETON = new ReceptionRepositoryImpl();


    private ReceptionRepositoryImpl() {
    }

    public static ReceptionRepository getSingleton() {
        return SINGLETON;
    }

    @Override
    public Set<Reception> getReceptions() {
        try (PreparedStatement statement = ApplicationDataSource.getConnection().prepareStatement("select * from reception")) {
            ResultSet set = statement.executeQuery();
            return mapResultSetToPatient(set);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    private static Set<Reception> mapResultSetToPatient(ResultSet set) {
        Set<Reception> receptions = new HashSet<>();
        while (set.next()) {
            int id = set.getInt("id");
            int patientId = set.getInt("patientId");
            int doctorId = set.getInt("doctorId");
            String status = set.getString("status");
            String date = String.valueOf(set.getDate("date"));
            Reception reception = new Reception(patientId, doctorId, status, date);
            reception.setId(id);
            receptions.add(reception);
        }
        return receptions;
    }

    @Override
    public void save(Reception reception) {
        try (PreparedStatement statement = ApplicationDataSource.getConnection()
                .prepareStatement("insert into reception (patientId, doctorId, status, date) values (" +
                        reception.getPatientId() + ", " + reception.getDoctorId() + ", '" + reception.getStatus() +
                        "', '" + reception.getDate() + "')")) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void changeStatus(Reception reception, String status) {
        try (PreparedStatement statement = ApplicationDataSource.getConnection()
                .prepareStatement("UPDATE reception SET status = '" + status + "' where id = " + reception.getId())) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(Reception reception) {
        try (PreparedStatement statement = ApplicationDataSource.getConnection()
                .prepareStatement("delete from reception where id = " + reception.getId())) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
