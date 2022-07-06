package players;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Reception {

    @EqualsAndHashCode.Include
    private int id = generateId();
    private static int idCounter = 0;
    private int patientId;
    private int doctorId;
    private String status;
    private String date;

    public Reception(int patientId, int doctorId, String status, String date) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.status = status;
        this.date = date;
    }

    public static synchronized Integer generateId() {
        return idCounter++;
    }

}
