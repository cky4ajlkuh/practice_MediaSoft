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

    private static final Map<CommandType, Executor> COMMAND_EXECUTORS_GROUPED_BY_COMMAND = Map.ofEntries(
            //Map.entry(CommandType.CREATE_PATIENT, new PatientCreated()),
            Map.entry(CommandType.CREATE_DOCTOR, new DoctorCreated()),
           // Map.entry(CommandType.CREATE_RECEPTION, new ReceptionCreated()),
           // Map.entry(CommandType.REMOVE_PATIENT, new PatientRemoved()),
            Map.entry(CommandType.REMOVE_DOCTOR, new DoctorRemoved()),
            Map.entry(CommandType.REMOVE_RECEPTION, new ReceptionRemoved()),
         //   Map.entry(CommandType.WRITE_ALL_PATIENTS, new PatientViewAll()),
            Map.entry(CommandType.WRITE_ALL_DOCTORS, new DoctorViewAll()),
          //  Map.entry(CommandType.WRITE_ALL_RECEPTIONS, new ReceptionViewAll()),
            Map.entry(CommandType.CHANGE_STATUS, new ReceptionChangeStatus())
         //   Map.entry(CommandType.CHANGE_NAME, new PatientChangeName())
    );

    /**
     * Доступные команды:
     * "Создать пациента <Кличка>"
     * "Создать прием <ID_пациента> <ID_доктора> <ГГГГ-ММ-ДД>", при создании приема, статус устанавливается "Новый" автоматически.
     * "Создать доктора <Имя> <Фамилия> <Специальность>"
     * "Удалить доктора <ID_доктора>"
     * "Удалить прием <ID_приема>"
     * "Удалить пациента <ID_пациента>", вводим id пациента, которого надо удалить.
     * "Вывести всех пациентов", можно добавить ключи для фильтрации "-f" и сортировки "-s"
     * "Вывести всех докторов"
     * "Вывести все приемы <ID_пациента>"
     * "Сменить кличку <ID_пациента> <Новая_кличка>"
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
        if (commandString.contains("Создать прием")) {
            return CommandType.CREATE_RECEPTION;
        }
        if (commandString.contains("Удалить пациента")) {
            return CommandType.REMOVE_PATIENT;
        }
        if (commandString.contains("Удалить доктора")) {
            return CommandType.REMOVE_DOCTOR;
        }
        if (commandString.contains("Удалить прием")) {
            return CommandType.REMOVE_RECEPTION;
        }
        if (commandString.contains("Вывести всех пациентов")) {
            return CommandType.WRITE_ALL_PATIENTS;
        }
        if (commandString.contains("Вывести все приемы")) {
            return CommandType.WRITE_ALL_RECEPTIONS;
        }
        if (commandString.contains("Вывести всех докторов")) {
            return CommandType.WRITE_ALL_DOCTORS;
        }
        if (commandString.contains("Сменить кличку")) {
            return CommandType.CHANGE_NAME;
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
