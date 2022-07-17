package command.executor;

import command.CommandType;
import players.Doctor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DoctorViewAll extends AbstractExecutor {
    @Override
    public int execute(String command) {
        return viewAllDoctors(command);
    }

    private int viewAllDoctors(String command) {
        List<Doctor> doctors = new ArrayList<>(doctorRepository.getDoctors());
        if (command.contains("-ф")) {
            doctors = doctors
                    .stream()
                    .sorted(Comparator.comparing(Doctor::getId))
                    .collect(Collectors.toList());
        }
        for (Doctor doctor : doctors) {
            System.out.printf("id: %d, Имя: %s, Фамилия: %s, Специальность: %s \n", doctor.getId(),
                    doctor.getFirstName(), doctor.getLastName(), doctor.getSpecialization());
        }
        return 1;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.WRITE_ALL_DOCTORS;
    }
}
