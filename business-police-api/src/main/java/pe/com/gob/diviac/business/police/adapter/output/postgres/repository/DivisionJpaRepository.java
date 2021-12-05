package pe.com.gob.diviac.business.police.adapter.output.postgres.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.DivisionEntity;

public interface DivisionJpaRepository extends JpaRepository<DivisionEntity, UUID> {

    Optional<DivisionEntity> findByIdAndState(UUID id, Boolean state);
}
