package pe.com.gob.diviac.support.audit.producer.domain.interactor;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import pe.com.gob.diviac.support.audit.producer.domain.port.input.ProducerUseCase;
import pe.com.gob.diviac.support.audit.producer.domain.port.output.ProducerPort;
import pe.com.gob.diviac.support.audit.producer.entity.Audit;
import pe.com.gob.diviac.support.audit.producer.util.JsonUtils;
import pe.com.gob.diviac.support.audit.producer.util.SecurityUtils;

@Slf4j
@Builder
@RequiredArgsConstructor
public class ProducerInteractor implements ProducerUseCase {

    private final ProducerPort producerPort;

    @Override
    public void produceAuditMessage(Audit audit) {
        this.signAuditMessage(audit);
        producerPort.produceAuditMessage(audit);
    }

    private void signAuditMessage(Audit audit) {
        audit.setSignRecord(this.cipherAudit(audit));
    }

    private String cipherAudit(Audit audit) {
        String auditJson;

        auditJson = JsonUtils.toJson(audit);
        return SecurityUtils.cipherBySha256(auditJson);
    }

}
