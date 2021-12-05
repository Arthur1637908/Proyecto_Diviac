package pe.com.gob.diviac.channel.administration.utils.constants;

public class ValidationConstants {

    public static final String REGEX_FILTER_CODE_DIVISION = "[A-Z0-9]{0,50}";
    public static final String REGEX_FILTER_NAME_DIVISION = "[A-ZÁ-ÜÑ\\- ]{0,255}";

    public static final String REGEX_NAME_DIVISION = "[A-ZÁ-ÜÑ\\- ]{1,255}";
    public static final String REGEX_DESCRIPTION_DIVISION = "[A-Z0-9Á-ÜÑ\\(\\)_;\\-:,. ]{0,255}";
    public static final String REGEX_ACRONYM_DIVISION = "[A-Z0-9]{0,255}";

    public static final String REGEX_NAME_ADDRESS = "[A-Z0-9Á-ÜÑ/.\\- ]{1,255}";
    public static final String REGEX_NUMBER_ADDRESS = "[A-Z0-9Ñ/.\\- ]{1,255}";

    public static final String REGEX_EMAIL_CONTACT = "[A-Z0-9.\\-_]{1,240}(@POLICIA.GOB.PE|@GMAIL.COM|@HOTMAIL.COM)";
    public static final String REGEX_PHONE_NUMBER_CONTACT = "[0-9]{7,9}";
    public static final String REGEX_ANNEX_NUMBER_CONTACT = "[0-9]{0,255}";
}
