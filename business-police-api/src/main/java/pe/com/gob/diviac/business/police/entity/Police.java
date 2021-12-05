package pe.com.gob.diviac.business.police.entity;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Police {

    private UUID id;
    private Division division;
    private String cip;
    private String firstName;
    private String secondName;
    private String lastName;
    private String secondLastName;
    private Parameter position;
    private Parameter grade;
    private Parameter sex;
    private LocalDate dateOfBirth;
    private String pseudonym;
    private Parameter civilStatus;
    private Boolean state;
}
