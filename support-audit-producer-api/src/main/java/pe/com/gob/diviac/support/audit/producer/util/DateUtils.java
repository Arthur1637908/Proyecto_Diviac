package pe.com.gob.diviac.support.audit.producer.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static final String DD_MM_YYYY_HH_MM_SS = "dd/mm/yyyy HH:mm:ss";

    public static String format(LocalDateTime localDateTime , String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(formatter);
    }
}
