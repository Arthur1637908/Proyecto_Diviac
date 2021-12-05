package pe.com.gob.diviac.business.parameter.adapter.output.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity.ProvinceEntity;

import java.util.List;

public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Integer> {

    List<ProvinceEntity> findAllByIntIdDepartamento(Integer idDepartamento);

}
