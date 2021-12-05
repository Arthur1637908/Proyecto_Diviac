package pe.com.gob.diviac.business.police.adapter.output.postgres.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.PoliceDivisionEntity;

public interface PoliceDivisionJpaRepository extends JpaRepository<PoliceDivisionEntity, Long> {

    Optional<PoliceDivisionEntity> findByPoliceIdAndDivisionIdAndState(UUID policeId, UUID divisionId, Boolean state);

    Optional<PoliceDivisionEntity> findByPoliceIdAndState(UUID policeId, Boolean state);
}
