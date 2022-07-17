package players;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Setter
@Getter
public class Patient implements Serializable {
    private String name;
    private final String emailOwner;
    @EqualsAndHashCode.Include
    private final int id;

    private final String formattedDate;

    public Patient(int id, String name, String emailOwner) {
        this.id = id;
        this.name = name;
        this.emailOwner = emailOwner;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        formattedDate = formatter.format(Date.from(Instant.now()));
    }
}
