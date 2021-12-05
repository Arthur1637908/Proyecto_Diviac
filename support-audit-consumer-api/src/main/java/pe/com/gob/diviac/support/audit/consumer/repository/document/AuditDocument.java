package pe.com.gob.diviac.support.audit.consumer.repository.document;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Builder
@Document(collection = "Audit")
public class AuditDocument {

    @Id
    @Field(name = "id")
    private String id;

    @Field(name = "transactionId")
    private String transactionId;

    @Field(name = "applicationId")
    private String applicationId;

    @Field(name = "applicationName")
    private String applicationName;

    @Field(name = "consumerId")
    private String consumerId;

    @Field(name = "changeDateTime")
    private String changeDateTime;

    @Field(name = "functionalAction")
    private String functionalAction;

    @Field(name = "httpStatus")
    private String httpStatus;

    @Field(name = "recordBeforeChange")
    private String recordBeforeChange;

    @Field(name = "recordAfterChange")
    private String recordAfterChange;

    @Field(name = "recordSign")
    private String recordSign;

}
