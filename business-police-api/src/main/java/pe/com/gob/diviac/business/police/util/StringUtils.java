package pe.com.gob.diviac.business.police.util;

import java.util.Objects;
import java.util.stream.IntStream;

public final class StringUtils {

    public static final String EMPTY = org.apache.commons.lang3.StringUtils.EMPTY;
    public static final String SPACE = org.apache.commons.lang3.StringUtils.SPACE;
    public static final String PERCENT = "%";
    public static final String CONCAT_CHAR = "%s";

    public static String concatFields(String... fields) {
        if (Objects.isNull(fields) || fields.length == 0) {
            return EMPTY;
        }

        String concatFormat = buildConcatFormat(fields);

        return String.format(concatFormat, (Object[]) fields).trim();
    }

    private static String buildConcatFormat(String... fields) {
        StringBuilder stringBuilder = new StringBuilder();

        IntStream.range(0, fields.length)
                .forEach(index-> stringBuilder.append(CONCAT_CHAR.concat(SPACE)));

        return stringBuilder.toString();
    }
}
