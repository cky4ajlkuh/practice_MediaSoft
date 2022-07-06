package players;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Doctor {
    private String firstName;
    private String lastName;
    private String specialization;
    private static int idCounter = 0;

    @EqualsAndHashCode.Include
    private int id = generateId();

    public Doctor(String firstName, String lastName, String specialization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
    }

    public static synchronized Integer generateId() {
        return idCounter++;
    }

}
