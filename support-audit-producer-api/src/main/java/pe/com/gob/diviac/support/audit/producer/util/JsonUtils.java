package pe.com.gob.diviac.support.audit.producer.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtils {

    public static byte[] toBytes(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object).getBytes();
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public static String toJson(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
