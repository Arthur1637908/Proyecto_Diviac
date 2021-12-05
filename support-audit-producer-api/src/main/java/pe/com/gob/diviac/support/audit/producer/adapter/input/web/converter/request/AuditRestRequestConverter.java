package pe.com.gob.diviac.support.audit.producer.adapter.input.web.converter.request;

import java.time.LocalDateTime;
import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import pe.com.gob.diviac.support.audit.producer.adapter.input.web.model.request.AuditRestRequest;
import pe.com.gob.diviac.support.audit.producer.entity.Audit;
import pe.com.gob.diviac.support.audit.producer.util.DateUtils;

@Builder
@RequiredArgsConstructor
public class AuditRestRequestConverter
        implements Function<AuditRestRequest, Audit> {

    @Override
    public Audit apply(AuditRestRequest auditRestRequest) {
        if (auditRestRequest == null) return null;

        return Audit.builder()
                .transactionId(auditRestRequest.getTransactionId())
                .applicationId(auditRestRequest.getApplicationId())
                .applicationName(auditRestRequest.getApplicationName())
                .consumerId(auditRestRequest.getConsumerId())
                .changeDateTime(DateUtils.format(LocalDateTime.now(), DateUtils.DD_MM_YYYY_HH_MM_SS))
                .functionalActionCode(auditRestRequest.getFunctionalActionCode())
                .httpStatus(auditRestRequest.getHttpStatus())
                .recordBeforeChange(auditRestRequest.getRecordBeforeChange())
                .recordAfterChange(auditRestRequest.getRecordAfterChange())
                .build();
    }
}
