package players;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class Patient {
    private String name;
    private final int id = generateId();
    private final String formattedDate;
    private static int idCounter = 0;

    public Patient(String name) {
        this.name = name;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        formattedDate = formatter.format(Date.from(Instant.now()));
    }

    public static synchronized Integer generateId() {
        return idCounter++;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId() {
        generateId();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(formattedDate, patient.formattedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formattedDate);
    }
}
