package command.executor;

import command.CommandType;
import players.Doctor;

public class DoctorCreate extends AbstractExecutor {
    @Override
    public int execute(String text) {
        return createDoctor(text);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_DOCTOR;
    }

    private int createDoctor(String command) {
        String[] words = command.split(" ");
        try {
            doctorRepository.save(new Doctor(words[2], words[3], words[4]));
            System.out.println("Доктор создан!");
        } catch (Exception exception) {
            System.out.println("Проверьте правильность команды: Создать доктора <Имя> <Фамилия> <Специальность>");
        }

        return 1;
    }
}
