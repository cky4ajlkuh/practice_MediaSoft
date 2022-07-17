package players;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Doctor implements Serializable {
    private String firstName;
    private String lastName;
    private String specialization;
    @EqualsAndHashCode.Include
    private int id;

    public Doctor(String firstName, String lastName, String specialization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
    }

    public Doctor(int id, String firstName, String lastName, String specialization) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
    }
}
