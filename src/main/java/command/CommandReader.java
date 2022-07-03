package command;

import command.executor.*;

import java.util.Map;
import java.util.Scanner;

public class CommandReader {

    public static void startReadCommand() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите вашу команду: ");
            String command = scanner.nextLine();
            if (readCommand(command) == 0) {
                break;
            }
        }
        scanner.close();
    }

    private static final Map<CommandType, Executor> COMMAND_EXECUTORS_GROUPED_BY_COMMAND = Map.of(
            CommandType.CREATE_PATIENT, new PatientCreate(),
            CommandType.WRITE_ALL_PATIENTS, new PatientViewAll(),
            CommandType.DELETE_PATIENT, new PatientRemove(),
            CommandType.CHANGE_NAME, new PatientChangeName(),
            CommandType.CREATE_DOCTOR, new DoctorCreate(),
            CommandType.WRITE_ALL_DOCTORS, new DoctorViewAll(),
            CommandType.CHANGE_STATUS, new ReceptionChangeStatus(),
            CommandType.CREATE_RECEPTION, new ReceptionCreate(),
            CommandType.WRITE_ALL_RECEPTION, new ReceptionViewAll()
    );

    /**
     * Доступные команды:
     * "Создать пациента <Кличка>"
     * "Создать доктора <Имя> <Фамилия> <Специальность>"
     * "Удалить пациента <ID>", вводим id пациента, которого надо удалить.
     * "Вывести всех пациентов"
     * "Вывести всех докторов"
     * "Сменить кличку <ID_пациента> <Новая_кличка>"
     * "Создать прием <ID_пациента> <ID_доктора> <ГГГГ-ММ-ДД>", при создании приема, статус устанавливается "Новый" автоматически.
     * "Вывести все приемы <ID_пациента>"
     * "Сменить статус приема <ID_приема> <Новый_статус>", статус можно выбрать из ограниченного набора.
     * "Выйти"
     */
    private static int readCommand(String command) {
        CommandType commandType = getCommandType(command);

        if (COMMAND_EXECUTORS_GROUPED_BY_COMMAND.containsKey(commandType)) {
            var commandExecutor = COMMAND_EXECUTORS_GROUPED_BY_COMMAND.get(commandType);
            return commandExecutor.execute(command);
        }
        if (commandType == CommandType.EXIT) {
            return 0;
        }
        System.out.println("Неверная команда!");
        return 1;
    }

    private static CommandType getCommandType(String commandString) {
        if (commandString.contains("Создать пациента")) {
            return CommandType.CREATE_PATIENT;
        }
        if (commandString.contains("Создать доктора")) {
            return CommandType.CREATE_DOCTOR;
        }
        if (commandString.contains("Удалить пациента")) {
            return CommandType.DELETE_PATIENT;
        }
        if (commandString.contains("Вывести всех пациентов")) {
            return CommandType.WRITE_ALL_PATIENTS;
        }
        if (commandString.contains("Сменить кличку")) {
            return CommandType.CHANGE_NAME;
        }
        if (commandString.contains("Создать прием")) {
            return CommandType.CREATE_RECEPTION;
        }
        if (commandString.contains("Вывести все приемы")) {
            return CommandType.WRITE_ALL_RECEPTION;
        }
        if (commandString.contains("Вывести всех докторов")) {
            return CommandType.WRITE_ALL_DOCTORS;
        }
        if (commandString.contains("Сменить статус приема")) {
            return CommandType.CHANGE_STATUS;
        }
        if (commandString.contains("Выйти")) {
            return CommandType.EXIT;
        }
        return CommandType.UNDEFINED;
    }
}
