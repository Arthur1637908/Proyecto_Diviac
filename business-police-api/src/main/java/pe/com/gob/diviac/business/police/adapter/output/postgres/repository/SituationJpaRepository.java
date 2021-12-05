package pe.com.gob.diviac.business.police.adapter.output.postgres.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.SituationEntity;

public interface SituationJpaRepository extends JpaRepository<SituationEntity, Long>,
        PagingAndSortingRepository<SituationEntity, Long> {

    Page<SituationEntity> findByPoliceIdAndState(UUID policeId, Boolean state, Pageable pageable);

    Optional<List<SituationEntity>> findByPoliceIdAndState(UUID id, Boolean state);

    Optional<SituationEntity> findByIdAndState(Long id, Boolean state);
}
