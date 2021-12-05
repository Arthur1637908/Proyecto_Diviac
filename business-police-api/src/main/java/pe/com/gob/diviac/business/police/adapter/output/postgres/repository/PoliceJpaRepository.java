package pe.com.gob.diviac.business.police.adapter.output.postgres.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.PoliceEntity;

public interface PoliceJpaRepository extends JpaRepository<PoliceEntity, UUID>,
        JpaSpecificationExecutor<PoliceEntity> {

    Optional<PoliceEntity> findByIdAndState(UUID id, Boolean state);

    Optional<PoliceEntity> findByCipAndState(String cip, Boolean state);

}
