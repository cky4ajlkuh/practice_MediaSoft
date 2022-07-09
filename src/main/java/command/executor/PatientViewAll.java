package command.executor;

import command.CommandType;
import context.UserContext;
import players.Patient;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PatientViewAll extends AbstractExecutor {
    @Override
    public int execute(String command) {
        return viewAllPatients(command);
    }

    private int viewAllPatients(String command) {
        List<Patient> patients = new ArrayList<>(patientRepository.getPatients());
        if (command.contains("-f")) {
            patients = patients
                    .stream()
                    .filter(patient -> patient.getEmailOwner().equals(UserContext.getUserLogin()))
                    .collect(Collectors.toList());
        }
        if (command.contains("-s")) {
            patients = patients
                    .stream()
                    .sorted(Comparator.comparing(Patient::getFormattedDate))
                    .collect(Collectors.toList());
        }
        for (Patient patient : patients) {
            System.out.printf("id: %d, Дата регистрации: %s, Имя: %s, Хозяин: %s \n", patient.getId(),
                    patient.getFormattedDate(), patient.getName(), patient.getEmailOwner());
        }
        return 1;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.WRITE_ALL_PATIENTS;
    }

}
