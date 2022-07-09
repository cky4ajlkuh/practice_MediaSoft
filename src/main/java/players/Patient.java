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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Patient implements Serializable {
    private String name;
    private final String emailOwner;
    private final int id = generateId();

    @EqualsAndHashCode.Include
    private final String formattedDate;
    private static int idCounter = 0;

    public Patient(String name, String emailOwner) {
        this.name = name;
        this.emailOwner = emailOwner;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        formattedDate = formatter.format(Date.from(Instant.now()));
    }

    public static synchronized Integer generateId() {
        return idCounter++;
    }

}
