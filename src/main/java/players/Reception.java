package players;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Reception implements Serializable {

    @EqualsAndHashCode.Include
    private int id;
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

    public Reception(int id, int patientId, int doctorId, String status, String date) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.status = status;
        this.date = date;
    }
}
