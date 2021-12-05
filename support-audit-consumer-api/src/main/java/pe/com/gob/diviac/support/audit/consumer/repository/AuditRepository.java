package pe.com.gob.diviac.support.audit.consumer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import pe.com.gob.diviac.support.audit.consumer.repository.document.AuditDocument;

public interface AuditRepository extends MongoRepository<AuditDocument, String> {
}
