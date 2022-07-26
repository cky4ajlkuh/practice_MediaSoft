package command.executor;

import command.CommandType;
import players.Patient;

import java.util.Optional;
/*
public class PatientChangeName extends AbstractExecutor {
    @Override
    public int execute(String command) {
        return changeName(command);
    }

    private int changeName(String command) {
        String[] words = command.split(" ");
        try {
            Optional<Patient> patientToChange = findPatient(Integer.parseInt(words[2]));
            if (patientToChange.isPresent()) {
                patientRepository.changeName(patientToChange.get(), words[3]);
                System.out.println("Кличка изменена успешно!");
            } else {
                System.out.println("Пациент не найден!");
            }
        } catch (Exception exception) {
            System.out.println("Проверьте правильность команды: Сменить кличку <ID_пациента> <Новая_кличка>");
        }

        return 1;
    }

    @Override
    public CommandType getCommandType() {
        return null;
    }
}
*/