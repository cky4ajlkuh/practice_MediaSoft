package players;

import java.util.Objects;

public class Reception {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reception reception = (Reception) o;
        return id == reception.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
