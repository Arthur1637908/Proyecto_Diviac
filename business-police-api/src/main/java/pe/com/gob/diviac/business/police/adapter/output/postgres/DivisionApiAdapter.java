package pe.com.gob.diviac.business.police.adapter.output.postgres;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;

import pe.com.gob.diviac.business.police.adapter.output.postgres.entity.DivisionEntity;
import pe.com.gob.diviac.business.police.adapter.output.postgres.repository.DivisionJpaRepository;
import pe.com.gob.diviac.business.police.domain.port.output.DivisionPort;
import pe.com.gob.diviac.business.police.entity.Division;
import pe.com.gob.diviac.business.police.util.constants.ErrorConstants;
import pe.com.gob.diviac.business.police.util.exception.DiviacStatusException;

@Slf4j
@Builder
@RequiredArgsConstructor
public class DivisionApiAdapter implements DivisionPort {

    private final DivisionJpaRepository divisionJpaRepository;
    private final Function<DivisionEntity, Division> divisionConverter;

    @Override
    public Division findByDivisionId(UUID id) {
        Optional<DivisionEntity> optionalDivisionEntityFound;
        Division division;

        log.info("Starting DivisionApiAdapter.findByDivisionId");
        optionalDivisionEntityFound = divisionJpaRepository.findByIdAndState(id, Boolean.TRUE);

        if (!optionalDivisionEntityFound.isPresent()) {
            throw new DiviacStatusException(HttpStatus.NOT_FOUND,
                    ErrorConstants.ERROR_DIVISION_NOT_FOUND_CODE,
                    ErrorConstants.ERROR_DIVISION_NOT_FOUND_DESCRIPTION);
        }

        division = divisionConverter.apply(optionalDivisionEntityFound.get());
        log.info("Finish DivisionApiAdapter.findByDivisionId successfully");

        return division;
    }
}
