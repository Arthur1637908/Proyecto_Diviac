package pe.com.gob.diviac.business.parameter.adapter.output.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {

}
