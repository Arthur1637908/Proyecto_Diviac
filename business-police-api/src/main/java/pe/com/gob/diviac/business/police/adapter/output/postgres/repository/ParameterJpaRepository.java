package pe.com.gob.diviac.business.police.adapter.output.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.ParameterEntity;

import java.util.Optional;

public interface ParameterJpaRepository extends JpaRepository<ParameterEntity, Integer> {

    Optional<ParameterEntity> findByIdAndState(Integer id, Boolean state);
}
