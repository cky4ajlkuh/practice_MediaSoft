package command.executor;

import command.CommandType;
import players.Patient;
import players.Reception;

import java.util.Optional;

public class ReceptionViewAll extends AbstractExecutor {
    @Override
    public int execute(String command) {
        return viewAllReceptions(command);
    }

    private int viewAllReceptions(String command) {
        String[] words = command.split(" ");
        try {
            Optional<Patient> patient = findPatient(Integer.parseInt(words[3]));
            if (patient.isPresent()) {
                for (Reception reception : receptionRepository.getReceptions()) {
                    if (reception.getPatientId() == patient.get().getId()) {
                        System.out.printf("ID Приема: %s, ID Пациента: %s, ID Доктора: %s, Статус приема: %s, Дата приема: %s \n", reception.getId(),
                                reception.getPatientId(), reception.getDoctorId(), reception.getStatus(), reception.getDate());
                    }
                }
            }
        } catch (Exception exception) {
            System.out.println("Проверьте правильность команды: Вывести все приемы <ID_пациента>");
        }

        return 1;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.WRITE_ALL_RECEPTIONS;
    }
}
