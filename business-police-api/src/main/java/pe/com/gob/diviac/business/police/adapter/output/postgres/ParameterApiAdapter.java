package pe.com.gob.diviac.business.police.adapter.output.postgres;

import java.util.Optional;
import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;

import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.ParameterEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.repository.ParameterJpaRepository;
import pe.com.gob.diviac.business.police.domain.port.output.ParameterPort;
import pe.com.gob.diviac.business.police.entity.Parameter;
import pe.com.gob.diviac.business.police.util.constants.ErrorConstants;
import pe.com.gob.diviac.business.police.util.exception.DiviacStatusException;

@Slf4j
@Builder
@RequiredArgsConstructor
public class ParameterApiAdapter implements ParameterPort {

    private final ParameterJpaRepository parameterJpaRepository;
    private final Function<ParameterEntity, Parameter> parameterConverter;

    @Override
    public Parameter findByParameterId(Integer id) {
        Optional<ParameterEntity> optionalParameterEntity;
        Parameter parameter;

        log.info("Starting ParameterApiAdapter.findByParameterId");
        optionalParameterEntity = parameterJpaRepository.findByIdAndState(id, Boolean.TRUE);

        if (!optionalParameterEntity.isPresent()) {
            throw new DiviacStatusException(HttpStatus.NOT_FOUND,
                    ErrorConstants.ERROR_PARAMETER_NOT_FOUND_CODE,
                    ErrorConstants.ERROR_PARAMETER_NOT_FOUND_DESCRIPTION);
        }

        parameter = parameterConverter.apply(optionalParameterEntity.get());
        log.info("Finish ParameterApiAdapter.findByParameterId successfully");

        return parameter;
    }
}
