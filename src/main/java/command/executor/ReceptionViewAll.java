package command.executor;

import command.CommandType;
import players.Patient;
import players.Reception;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
                List<Reception> receptions = new ArrayList<>(receptionRepository.getReceptions());
                if (command.contains("-ф")) {
                    receptions = receptions
                            .stream()
                            .sorted(Comparator.comparing(Reception::getId))
                            .collect(Collectors.toList());
                }
                for (Reception reception : receptions) {
                    if (reception.getPatientId() == patient.get().getId()) {
                        System.out.printf("ID Приема: %s, ID Пациента: %s, ID Доктора: %s, Статус приема: %s, Дата приема: %s \n",
                                reception.getId(), reception.getPatientId(),
                                reception.getDoctorId(), reception.getStatus(), reception.getDate());
                    }
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return 1;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.WRITE_ALL_RECEPTIONS;
    }
}
