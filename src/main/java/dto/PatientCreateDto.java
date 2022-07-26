package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PatientCreateDto {
    private final String name;
    private final String emailOwner;

    public PatientCreateDto(@JsonProperty("name") String name,
                            @JsonProperty("emailOwner") String emailOwner) {
        this.name = name;
        this.emailOwner = emailOwner;
    }
}
