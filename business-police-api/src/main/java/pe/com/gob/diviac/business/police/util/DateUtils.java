package pe.com.gob.diviac.business.police.util;

import pe.com.gob.diviac.business.police.util.enums.DateFormatEnum;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String format(LocalDate localDate, DateFormatEnum dateFormatEnum) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormatEnum.getPattern());
        return dateTimeFormatter.format(localDate);
    }

    public static LocalDate parse(String localDateStr, DateFormatEnum dateFormatEnum) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormatEnum.getPattern());
        return LocalDate.parse(localDateStr, dateTimeFormatter);
    }
}
