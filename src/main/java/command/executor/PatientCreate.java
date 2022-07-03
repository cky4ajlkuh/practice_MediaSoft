package command.executor;

import command.CommandType;
import players.Patient;

public class PatientCreate extends AbstractExecutor {
    @Override
    public int execute(String text) {
        return createPatient(text);
    }

    private int createPatient(String command) {
        String[] words = command.split(" ");
        try {
            patientRepository.save(new Patient(words[2]));
            System.out.println("Пациент создан!");
        } catch (Exception exception) {
            System.out.println("Проверьте правильность команды: Создать пациента <Кличка>");
        }
        return 1;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_PATIENT;
    }
}
