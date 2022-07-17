package command.executor;

import command.CommandType;
import command.StatusType;
import players.Reception;

import java.util.Optional;

public class ReceptionChangeStatus extends AbstractExecutor {
    @Override
    public int execute(String command) {
        return changeStatus(command);
    }

    private int changeStatus(String command) {
        String[] words = command.split(" ");
        try {
            Optional<Reception> receptionToChange = findReception(Integer.parseInt(words[3]));
            if (receptionToChange.isPresent()) {
                try {
                    StatusType.valueOf(words[4]);
                    receptionRepository.changeStatus(receptionToChange.get(), words[4]);
                    System.out.println("Статус приема изменен!");
                } catch (Exception exception) {
                    System.out.println("Неверный статус или команда! Варианты статусов: Новый, Ожидает, Проходит, Оплачен, Отменен");
                }
            } else {
                System.out.println("Прием не найден!");
            }
        } catch (Exception e) {
            System.out.println("Проверьте правильность команды: Сменить статус приема <ID_приема> <Новый_статус>");
        }
        return 1;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CHANGE_STATUS;
    }

}
