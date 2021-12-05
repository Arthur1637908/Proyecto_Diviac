package pe.com.gob.diviac.business.police.util.constants;

public class ErrorConstants {

    public static final String ERROR_INVALID_REQUEST_CODE = "DV0001";
    public static final String ERROR_INVALID_REQUEST_DESCRIPTION = "Petición inválida o incompleta.";

    public static final String ERROR_DIVISION_NOT_FOUND_CODE = "DV0002";
    public static final String ERROR_DIVISION_NOT_FOUND_DESCRIPTION = "La división ingresada, no existe o ha sido eliminada.";

    public static final String ERROR_POLICE_NOT_FOUND_CODE = "DV0003";
    public static final String ERROR_POLICE_NOT_FOUND_DESCRIPTION = "El efectivo policial ingresado, no existe o ha sido eliminado.";

    public static final String ERROR_POLICE_ALREADY_EXISTS_CODE = "DV0004";
    public static final String ERROR_POLICE_ALREADY_EXISTS_DESCRIPTION = "Ya se cuenta con el registro de un efectivo policial con el mismo CIP.";

    public static final String ERROR_PARAMETER_NOT_FOUND_CODE = "DV0005";
    public static final String ERROR_PARAMETER_NOT_FOUND_DESCRIPTION = "El parámetro seleccionado, no existe o ha sido eliminado.";

    public static final String ERROR_SITUATION_NOT_FOUND_CODE = "DV0006";
    public static final String ERROR_SITUATION_NOT_FOUND_DESCRIPTION = "La situación ingresada, no existe o ha sido eliminada.";

    public static final String ERROR_IDENTITY_DOCUMENT_NOT_FOUND_CODE = "DV0007";
    public static final String ERROR_IDENTITY_DOCUMENT_NOT_FOUND_DESCRIPTION = "El documento de identidad, no existe o ha sido eliminado.";

    public static final String ERROR_IDENTITY_DOCUMENT_TYPE_DUPLICITY_CODE = "DV0008";
    public static final String ERROR_IDENTITY_DOCUMENT_TYPE_DUPLICITY_DESCRIPTION = "El efectivo policial ya registra un mismo tipo de documento.";

    public static final String ERROR_IDENTITY_DOCUMENT_NUMBER_DUPLICITY_CODE = "DV0009";
    public static final String ERROR_IDENTITY_DOCUMENT_NUMBER_DUPLICITY_DESCRIPTION = "Ya se cuenta con el registro del mismo documento de identidad.";

    public static final String ERROR_INTERNAL_SERVER_CODE = "DV9999";
    public static final String ERROR_INTERNAL_SERVER_DESCRIPTION = "Se ha producido un error interno en la aplicación.";

}
