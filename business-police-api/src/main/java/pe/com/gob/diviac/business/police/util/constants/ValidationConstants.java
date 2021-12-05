package pe.com.gob.diviac.business.police.util.constants;

public class ValidationConstants {

    // GET POLICES BY NAME AND DOCUMENT NUMBER - REGEX
    public static final String CIP_FILTER_REGEX = "[0-9]{0,255}";
    public static final String POLICE_NAME_FILTER_REGEX = "[A-ZÁ-ÜÑ ]{0,255}";
    public static final String DOCUMENT_NUMBER_FILTER_REGEX = "[A-Z0-9]{0,255}";

    // POLICES -  REGEX
    public static final String CIP_REGEX = "[0-9]{0,255}";
    public static final String FIRST_NAME_REGEX = "[A-ZÁ-ÜÑ]{1,255}";
    public static final String SECOND_NAME_REGEX = "[A-ZÁ-ÜÑ]{0,255}";
    public static final String LAST_NAME_REGEX = "[A-ZÁ-ÜÑ\\-]{1,255}";
    public static final String SECOND_LAST_NAME_REGEX = "[A-ZÁ-ÜÑ\\-]{1,255}";
    public static final String PSEUDONYM_REGEX = "[A-Z0-9]{0,255}";
    public static final String DOCUMENT_NUMBER_REGEX = "[A-Z0-9]{0,255}";
}
