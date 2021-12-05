package pe.com.gob.diviac.business.police.adapter.output.postgres.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.IdentityDocumentEntity;

public interface IdentityDocumentJpaRepository extends JpaRepository<IdentityDocumentEntity, Long>,
        JpaSpecificationExecutor<IdentityDocumentEntity> {

    Optional<List<IdentityDocumentEntity>> findByPoliceIdAndState(UUID id, Boolean state);

    Optional<IdentityDocumentEntity> findByIdAndState(Long id, Boolean state);

    Optional<IdentityDocumentEntity> findByPoliceIdAndDocumentTypeIdAndState(UUID id, Integer documentTypeId,
                                                                             Boolean state);

    Optional<IdentityDocumentEntity> findByDocumentTypeIdAndDocumentNumberAndState(Integer documentTypeId,
                                                                                   String documentNumber,
                                                                                   Boolean state);

    Optional<IdentityDocumentEntity> findByDocumentNumberAndState(String documentNumber, Boolean state);
}
