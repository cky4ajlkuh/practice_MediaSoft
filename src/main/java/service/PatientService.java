package service;

import dto.PatientCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import players.Patient;
import repository.PatientRepository;

@RequiredArgsConstructor
@Service
public class PatientService {

    private final PatientRepository repository;

    public void createPatient(PatientCreateDto body) {
        Patient newPatient = new Patient(body.getName(), body.getEmailOwner());
        repository.save(newPatient);
    }
}
