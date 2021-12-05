package pe.com.gob.diviac.support.audit.producer.domain.port.input;

import pe.com.gob.diviac.support.audit.producer.entity.Audit;

public interface ProducerUseCase {

    void produceAuditMessage(Audit audit);
}
