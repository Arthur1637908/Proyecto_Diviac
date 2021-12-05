package pe.com.gob.diviac.support.audit.consumer.entity;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import pe.com.gob.diviac.support.audit.consumer.util.enums.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Audit implements Serializable {

    private UUID transactionId;
    private String applicationId;
    private String applicationName;
    private String consumerId;
    private String changeDateTime;
    private String functionalActionCode;
    private HttpStatus httpStatus;
    private String recordBeforeChange;
    private String recordAfterChange;
    private String signRecord;

}
