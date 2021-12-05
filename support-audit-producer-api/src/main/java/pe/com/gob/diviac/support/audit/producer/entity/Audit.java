package pe.com.gob.diviac.support.audit.producer.entity;

import java.io.Serializable;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import pe.com.gob.diviac.support.audit.producer.util.enums.HttpStatus;

@Getter
@Setter
@Builder
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
