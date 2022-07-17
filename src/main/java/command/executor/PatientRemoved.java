package command.executor;

import command.CommandType;
import players.Patient;

import java.util.Optional;

public class PatientRemoved extends AbstractExecutor {

    @Override
    public int execute(String command) {
        return removePatient(command);
    }

    private int removePatient(String command) {
        String[] words = command.split(" ");
        try {
            Optional<Patient> patientToRemove = findPatient(Integer.parseInt(words[2]));
            if (patientToRemove.isPresent()) {
                patientRepository.remove(patientToRemove.get());
                System.out.println("Пациент удален!");
            } else {
                System.out.println("Пациент не найден");
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return 1;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.REMOVE_PATIENT;
    }
}
