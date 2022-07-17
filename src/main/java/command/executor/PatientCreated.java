package command.executor;

import command.CommandType;
import context.UserContext;
import players.Patient;

public class PatientCreated extends AbstractExecutor {
    @Override
    public int execute(String text) {
        return createPatient(text);
    }

    private int createPatient(String command) {
        String[] words = command.split(" ");
        try {
            patientRepository.save(new Patient(words[2], UserContext.getUserLogin()));
            System.out.println("Пациент создан!");
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return 1;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_PATIENT;
    }
}
