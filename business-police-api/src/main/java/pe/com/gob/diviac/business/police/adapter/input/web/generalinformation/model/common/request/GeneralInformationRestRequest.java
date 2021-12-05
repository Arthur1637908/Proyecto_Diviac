package pe.com.gob.diviac.business.police.adapter.input.web.generalinformation.model.common.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import org.springframework.format.annotation.DateTimeFormat;

import pe.com.gob.diviac.business.police.util.StringUtils;
import pe.com.gob.diviac.business.police.util.constants.ValidationConstants;

@Setter
@Getter
@AllArgsConstructor
public class GeneralInformationRestRequest {

    @NotNull
    @Schema(description = "Division identifier", example = "18de4eda-27ca-41c1-9461-db5f52c894c9", required = true)
    private UUID divisionId;

    @Pattern(regexp = ValidationConstants.FIRST_NAME_REGEX)
    @Schema(description = "First name", example = "MANOLO", required = true)
    private String firstName;

    @Pattern(regexp = ValidationConstants.SECOND_NAME_REGEX)
    @Schema(description = "Second name", example = "MANUEL")
    private String secondName;

    @Pattern(regexp = ValidationConstants.LAST_NAME_REGEX)
    @Schema(description = "Last name", example = "REYES", required = true)
    private String lastName;

    @Pattern(regexp = ValidationConstants.SECOND_LAST_NAME_REGEX)
    @Schema(description = "Second last name", example = "REYNOSO", required = true)
    private String secondLastName;

    @Min(1)
    @NotNull
    @Schema(description = "Position identifier", example = "1", required = true)
    private Integer positionId;

    @Min(1)
    @NotNull
    @Schema(description = "Grade identifier", example = "1", required = true)
    private Integer gradeId;

    @Min(1)
    @NotNull
    @Schema(description = "Sex identifier", example = "1", required = true)
    private Integer sexId;

    @NotBlank
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Schema(description = "Date of birth", example = "31/03/1993", format = "dd/MM/yyyy")
    private String dateOfBirth;

    @Pattern(regexp = ValidationConstants.PSEUDONYM_REGEX)
    @Schema(description = "Pseudonym", example = "AGUILA")
    private String pseudonym;

    @Min(1)
    @Schema(description = "Civil status identifier", example = "1", required = true)
    private Integer civilStatusId;

    public void setFirstName(String firstName) {
        if (Objects.nonNull(firstName) && !firstName.trim().equals(StringUtils.EMPTY)) {
            this.firstName = firstName.trim().toUpperCase();
        }
    }

    public void setSecondName(String secondName) {
        if (Objects.nonNull(secondName) && !secondName.trim().equals(StringUtils.EMPTY)) {
            this.secondName = secondName.trim().toUpperCase();
        }
    }

    public void setLastName(String lastName) {
        if (Objects.nonNull(lastName) && !lastName.trim().equals(StringUtils.EMPTY)) {
            this.lastName = lastName.trim().toUpperCase();
        }
    }

    public void setSecondLastName(String secondLastName) {
        if (Objects.nonNull(secondLastName) && !secondLastName.trim().equals(StringUtils.EMPTY)) {
            this.secondLastName = secondLastName.trim().toUpperCase();
        }
    }

    public void setDateOfBirth(String dateOfBirth) {
        if (Objects.nonNull(dateOfBirth) && !dateOfBirth.trim().equals(StringUtils.EMPTY)) {
            this.dateOfBirth = dateOfBirth.trim().toUpperCase();
        }
    }

    public void setPseudonym(String pseudonym) {
        if (Objects.nonNull(pseudonym) && !pseudonym.trim().equals(StringUtils.EMPTY)) {
            this.pseudonym = pseudonym.trim().toUpperCase();
        }
    }
}
