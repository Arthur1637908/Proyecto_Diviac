package pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.model.common.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.DivisionRestResponse;
import pe.com.gob.diviac.business.police.adapter.input.web.common.model.response.ParameterRestResponse;

@Getter
@Setter
@AllArgsConstructor
public class GeneralInformationRestResponse {

    @Schema(description = "Identifier", example = "67ad327e-7e4b-463b-b6de-200c9c9fe530")
    private UUID id;

    @Schema(description = "Police identification code", example = "9876543212")
    private String cip;

    @Schema(description = "Division information")
    private DivisionRestResponse division;

    @Schema(description = "First name", example = "MANOLO")
    private String firstName;

    @Schema(description = "Second name", example = "MANUEL")
    private String secondName;

    @Schema(description = "Last name", example = "REYES")
    private String lastName;

    @Schema(description = "Second last name", example = "REYNOSO")
    private String secondLastName;

    @Schema(description = "Position information")
    private ParameterRestResponse position;

    @Schema(description = "Grade information")
    private ParameterRestResponse grade;

    @Schema(description = "Sex information")
    private ParameterRestResponse sex;

    @Schema(description = "Date of birth", example = "31/03/1993")
    private String dateOfBirth;

    @Schema(description = "Pseudonym", example = "AGUILA")
    private String pseudonym;

    @Schema(description = "Civil status information")
    private ParameterRestResponse civilStatus;

    @Schema(description = "State", example = "true or false")
    private Boolean state;
}
