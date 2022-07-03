package command.executor;

import command.CommandType;
import players.Doctor;

public class DoctorViewAll extends AbstractExecutor {
    @Override
    public int execute(String text) {
        return viewAllDoctors();
    }

    private int viewAllDoctors() {
        for (Doctor doctor : doctorRepository.getDoctors()) {
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
