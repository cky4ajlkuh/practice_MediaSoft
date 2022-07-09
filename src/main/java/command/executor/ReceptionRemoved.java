package command.executor;

import command.CommandType;
import players.Reception;

import java.util.Optional;

public class ReceptionRemoved extends AbstractExecutor {
    @Override
    public int execute(String command) {
        return removeReception(command);
    }

    private int removeReception(String command) {
        String[] words = command.split(" ");
        try {
            Optional<Reception> receptionToRemove = findReception(Integer.parseInt(words[2]));
            if (receptionToRemove.isPresent()) {
                receptionRepository.remove(receptionToRemove.get());
                System.out.println("Прием удален!");
            } else {
                System.out.println("Прием не найден");
            }
        } catch (Exception exception) {
            System.out.println("Проверьте правильность команды: Удалить Прием <ID>");
        }
        return 1;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.REMOVE_RECEPTION;
    }
}
