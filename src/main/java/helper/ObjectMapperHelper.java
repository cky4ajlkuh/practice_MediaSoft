package helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class ObjectMapperHelper {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @SneakyThrows
    public static <T> T readValues(String value, Class<T> clazz) {
        return OBJECT_MAPPER.readValue(value, clazz);
    }
}
