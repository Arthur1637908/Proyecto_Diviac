package pe.com.gob.diviac.support.audit.consumer.repository.converter;

import java.util.function.Function;

import lombok.Builder;

import pe.com.gob.diviac.support.audit.consumer.repository.document.AuditDocument;
import pe.com.gob.diviac.support.audit.consumer.entity.Audit;
import pe.com.gob.diviac.support.audit.consumer.util.PropertiesReader;
import pe.com.gob.diviac.support.audit.consumer.util.enums.HttpStatus;

@Builder
public class AuditDocumentConverter
        implements Function<Audit, AuditDocument> {

    @Override
    public AuditDocument apply(Audit audit) {
        if (audit == null) return null;

        return AuditDocument.builder()
                .transactionId(audit.getTransactionId().toString())
                .applicationId(audit.getApplicationId())
                .applicationName(audit.getApplicationName())
                .consumerId(audit.getConsumerId())
                .changeDateTime(audit.getChangeDateTime())
                .functionalAction(this.buildFunctionalAction(audit.getFunctionalActionCode()))
                .httpStatus(this.buildHttpStatus(audit.getHttpStatus()))
                .recordBeforeChange(audit.getRecordBeforeChange())
                .recordAfterChange(audit.getRecordAfterChange())
                .recordSign(audit.getSignRecord())
                .build();
    }

    private String buildHttpStatus(HttpStatus httpStatus) {
        return String.format("[%s] - %s", httpStatus.getCode(), httpStatus.getDescription());
    }

    private String buildFunctionalAction(String functionalActionCode) {
        return PropertiesReader.readProperty(functionalActionCode);
    }
}
