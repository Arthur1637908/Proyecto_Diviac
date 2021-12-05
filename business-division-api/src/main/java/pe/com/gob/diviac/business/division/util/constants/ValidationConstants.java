package pe.com.gob.diviac.business.division.util.constants;

public class ValidationConstants {

    public static final String REGEX_CODE_DIVISION = "[A-Z0-9]{0,50}";
    public static final String REGEX_NAME_DIVISION = "[A-ZÁ-ÜÑ\\- ]{0,255}";
    public static final String REGEX_ACRONYM_DIVISION = "[A-Z0-9]{1,255}";
    public static final String REGEX_DESCRIPTION_DIVISION = "[A-Z0-9Á-ÜÑ\\(\\)_;\\-:,. ]{1,255}";
    public static final String REGEX_NAME_ADDRESS = "[A-Z0-9Á-ÜÑ\\-./ ]{1,255}";
    public static final String REGEX_NUMBER_ADDRESS = "[A-Z0-9Ñ\\-./ ]{1,255}";
    public static final String REGEX_EMAIL_CONTACT = "[A-Z0-9_\\-.]{1,240}(@POLICIA.GOB.PE|@GMAIL.COM|@HOTMAIL.COM)";
    public static final String REGEX_PHONENUMBER_CONTACT = "[0-9]{1,255}";
    public static final String REGEX_ANNEXNUMBER_CONTACT = "[0-9]{0,255}";
    public static final int MIN_VALUE_CURRENT_PAGE = 1;
    public static final int MAX_VALUE_CURRENT_PAGE = 9999;
    public static final int MIN_VALUE_PAGE_SIZE = 1;
    public static final int MAX_VALUE_PAGE_SIZE = 999;
    public static final int MIN_VALUE_TYPE_ID_ADDRESS = 1;
    public static final int MAX_VALUE_TYPE_ID_ADDRESS = 9999;
    public static final int MIN_VALUE_DISTRICT_ID_ADDRESS = 1;
    public static final int MAX_VALUE_DISTRICT_ID_ADDRESS = 9999;
    public static final String REGEX_DIVISION_ID = "[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}";

}
