package repository.impl;

import config.ApplicationDataSource;
import lombok.SneakyThrows;
import players.Doctor;
import repository.DoctorRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class DoctorRepositoryImpl implements DoctorRepository {
    private static final DoctorRepositoryImpl SINGLETON = new DoctorRepositoryImpl();

    private DoctorRepositoryImpl() {
    }

    public static DoctorRepository getSingleton() {
        return SINGLETON;
    }

    @Override
    public Set<Doctor> getDoctors() {
        try (PreparedStatement statement = ApplicationDataSource.getConnection().prepareStatement("select * from doctor")) {
            ResultSet set = statement.executeQuery();
            return mapResultSetToPatient(set);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    private static Set<Doctor> mapResultSetToPatient(ResultSet set) {
        Set<Doctor> doctors = new HashSet<>();
        while (set.next()) {
            int id = set.getInt("id");
            String firstName = set.getString("firstName");
            String lastName = set.getString("lastName");
            String specialization = set.getString("specialization");
            doctors.add(new Doctor(id, firstName, lastName, specialization));
        }
        return doctors;
    }

    @Override
    public void save(Doctor doctor) {
        try (PreparedStatement statement = ApplicationDataSource.getConnection()
                .prepareStatement("insert into doctor (firstName, lastName, specialization) values ('"
                        + doctor.getFirstName() + "', '" +
                        doctor.getLastName() + "', '" + doctor.getSpecialization() + "')")) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(Doctor doctor) {
        try (PreparedStatement statement = ApplicationDataSource.getConnection()
                .prepareStatement("delete from doctor where id = " + doctor.getId())) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
