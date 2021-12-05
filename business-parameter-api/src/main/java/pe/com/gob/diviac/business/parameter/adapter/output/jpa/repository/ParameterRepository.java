package pe.com.gob.diviac.business.parameter.adapter.output.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity.ParameterEntity;

public interface ParameterRepository extends JpaRepository<ParameterEntity, Integer> {

    @Query("FROM ParameterEntity" +
            " WHERE parameterGroupEntity.vchCodGrupo = :vchCodGrupo" +
            " AND parameterGroupEntity.bolEstado = :bolEstado")
    List<ParameterEntity> findAllByParameterGroupCodeAndParameterGroupState(@Param("vchCodGrupo") String vchCodGrupo,
                                                                            @Param("bolEstado") Boolean bolEstado);

}
