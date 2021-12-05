package pe.com.gob.diviac.business.parameter.adapter.output.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity.DistrictEntity;

import java.util.List;

public interface DistrictRepository extends JpaRepository<DistrictEntity, Integer> {

    List<DistrictEntity> findAllByIntIdProvincia(Integer idProvincia);

}
