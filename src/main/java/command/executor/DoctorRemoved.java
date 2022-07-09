package command.executor;

import command.CommandType;
import players.Doctor;

import java.util.Optional;

public class DoctorRemoved extends AbstractExecutor {
    @Override
    public int execute(String command) {
        return removeDoctor(command);
    }

    private int removeDoctor(String command) {
        String[] words = command.split(" ");
        try {
            Optional<Doctor> doctorToRemove = findDoctor(Integer.parseInt(words[2]));
            if (doctorToRemove.isPresent()) {
                doctorRepository.remove(doctorToRemove.get());
                System.out.println("Доктор удален!");
            } else {
                System.out.println("Доктор не найден");
            }
        } catch (Exception exception) {
            System.out.println("Проверьте правильность команды: Удалить Доктора <ID>");
        }
        return 1;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.REMOVE_DOCTOR;
    }
}
