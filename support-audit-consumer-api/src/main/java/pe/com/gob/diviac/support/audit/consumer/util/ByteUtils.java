package pe.com.gob.diviac.support.audit.consumer.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ByteUtils {

    public static <T> T toObject(byte[] bytes, Class<T> type) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(bytes, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
