package command.executor;

import command.CommandType;
import players.Patient;

public class PatientViewAll extends AbstractExecutor {
    @Override
    public int execute(String text) {
        return viewAllPatients();
    }

    private int viewAllPatients() {
        for (Patient patient : patientRepository.getPatients()) {
            System.out.printf("id: %d, Имя: %s, Дата регистрации: %s \n", patient.getId(),
                    patient.getName(), patient.getFormattedDate());
        }
        return 1;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.WRITE_ALL_PATIENTS;
    }

}
