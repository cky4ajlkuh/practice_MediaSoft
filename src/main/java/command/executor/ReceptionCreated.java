package command.executor;

import command.CommandType;
import players.Doctor;
import players.Patient;
import players.Reception;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class ReceptionCreated extends AbstractExecutor {

    @Override
    public int execute(String command) {
        return createReception(command);
    }

    private int createReception(String command) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String[] words = command.split(" ");
        Optional<Patient> patient = findPatient(Integer.parseInt(words[2]));
        Optional<Doctor> doctor = findDoctor(Integer.parseInt(words[3]));
        if (patient.isPresent() && doctor.isPresent()) {
            try {
                receptionRepository.save(new Reception(patient.get().getId(), doctor.get().getId(), "Новый", LocalDate.parse(words[4], formatter).toString()));
                System.out.println("Прием создан!");
            } catch (Exception exception) {
                System.out.println("Неверный формат даты! (ГГГГ-ММ-ДД)");
            }
        } else {
            System.out.println("Некорректный ввод данных!");
        }
        return 1;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_RECEPTION;
    }
}
