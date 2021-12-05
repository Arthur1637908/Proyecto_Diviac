package pe.com.gob.diviac.channel.administration.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtils {

    public static String toJson(Object o) {
        try {
            return new ObjectMapper().writeValueAsString(o);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T toObject(String json, Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(json, clazz);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
