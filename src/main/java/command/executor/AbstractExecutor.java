package command.executor;

import players.Doctor;
import players.Patient;
import players.Reception;
import repository.DoctorRepository;
import repository.PatientRepository;
import repository.ReceptionRepository;
import repository.impl.DoctorRepositoryImpl;
import repository.impl.PatientRepositoryImpl;
import repository.impl.ReceptionRepositoryImpl;

import java.util.Optional;

public abstract class AbstractExecutor implements Executor {
    protected final PatientRepository patientRepository = PatientRepositoryImpl.getSingleton();
    protected final DoctorRepository doctorRepository = DoctorRepositoryImpl.getSingleton();
    protected final ReceptionRepository receptionRepository = ReceptionRepositoryImpl.getSingleton();

    protected Optional<Patient> findPatient(int id) {
        for (Patient patient : patientRepository.getPatients()) {
            if (patient.getId() == id) {
                return Optional.of(patient);
            }
        }
        return Optional.empty();
    }

    protected Optional<Doctor> findDoctor(int id) {
        for (Doctor doctor : doctorRepository.getDoctors()) {
            if (doctor.getId() == id) {
                return Optional.of(doctor);
            }
        }
        return Optional.empty();
    }

    protected Optional<Reception> findReception(int id) {
        for (Reception reception : receptionRepository.getReceptions()) {
            if (reception.getId() == id) {
                return Optional.of(reception);
            }
        }
        return Optional.empty();
    }
}
