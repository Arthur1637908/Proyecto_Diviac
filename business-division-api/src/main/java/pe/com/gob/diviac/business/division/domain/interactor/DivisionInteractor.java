package pe.com.gob.diviac.business.division.domain.interactor;

import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import pe.com.gob.diviac.business.division.domain.port.output.AddressPort;
import pe.com.gob.diviac.business.division.domain.port.output.DivisionPort;
import pe.com.gob.diviac.business.division.domain.port.input.DivisionUseCase;
import pe.com.gob.diviac.business.division.entity.Division;
import pe.com.gob.diviac.business.division.entity.request.DivisionsListRequest;
import pe.com.gob.diviac.business.division.entity.response.DivisionsListResponse;
import pe.com.gob.diviac.business.division.entity.response.PageResponse;
import pe.com.gob.diviac.business.division.util.constants.ErrorConstants;
import pe.com.gob.diviac.business.division.util.exception.DiviacStatusException;

@Slf4j
@Builder
@RequiredArgsConstructor
public class DivisionInteractor implements DivisionUseCase {

    private final DivisionPort divisionPort;
    private final AddressPort addressPort;

    @Override
    @Transactional
    public Division insert(Division divisionToSave) {
        log.info("Starting DivisionInteractor.insert");

        this.prepareDivisionToSave(divisionToSave);
        addressPort.insert(divisionToSave.getAddress());
        divisionPort.insert(divisionToSave);

        log.info("Finish DivisionInteractor.insert successfully");

        return divisionPort.findById(divisionToSave.getId());

    }

    @Override
    public Division findById(UUID divisionId) {
        Division division;

        log.info("Starting DivisionInteractor.findById");

        division = divisionPort.findById(divisionId);

        if (division == null) {
            throw new DiviacStatusException(HttpStatus.NOT_FOUND,
                    ErrorConstants.ERROR_RESOURCE_NOT_FOUND_CODE,
                    ErrorConstants.ERROR_RESOURCE_NOT_FOUND_DESCRIPTION);
        }

        log.info("Finish DivisionInteractor.findById successfully");

        return division;

    }

    @Override
    @Transactional
    public DivisionsListResponse findAllByCodeAndName(DivisionsListRequest divisionsListRequest) {
        List<Division> divisions;
        PageResponse page;

        log.info("Starting DivisionInteractor.findAllByCodeAndName");

        divisions = divisionPort.findAllByCodeAndName(divisionsListRequest);
        page = divisionPort.getPage(divisionsListRequest);

        log.info("Finish DivisionInteractor.findAllByCodeAndName successfully");

        return DivisionsListResponse
                .builder()
                .divisions(divisions)
                .page(page)
                .build();
    }

    @Override
    @Transactional
    public Division update(Division division) {
        Division divisionFound;

        log.info("Starting DivisionInteractor.update");

        divisionFound = divisionPort.findById(division.getId());

        if (divisionFound == null) {
            throw new DiviacStatusException(HttpStatus.NOT_FOUND,
                    ErrorConstants.ERROR_RESOURCE_NOT_FOUND_CODE,
                    ErrorConstants.ERROR_RESOURCE_NOT_FOUND_DESCRIPTION);
        }

        division.getAddress().setId(divisionFound.getAddress().getId());

        if (division.getAddress() != null) {
            addressPort.update(division.getAddress());
        }

        divisionPort.update(division);

        log.info("Finish DivisionInteractor.update successfully");

        return divisionPort.findById(division.getId());
    }

    @Override
    @Transactional
    public void delete(UUID divisionId) {
        Division division;

        log.info("Starting DivisionInteractor.delete");

        division = divisionPort.findById(divisionId);

        if (division == null) {
            throw new DiviacStatusException(HttpStatus.NOT_FOUND, ErrorConstants.ERROR_RESOURCE_NOT_FOUND_CODE,
                    ErrorConstants.ERROR_RESOURCE_NOT_FOUND_DESCRIPTION);
        }

        addressPort.delete(division.getAddress().getId());
        divisionPort.delete(divisionId);

        log.info("Finish DivisionInteractor.delete successfully");
    }

    private void prepareDivisionToSave(Division divisionToSave) {
        UUID uuid = UUID.randomUUID();
        Long addressId = addressPort.getSequence();

        divisionToSave.setId(uuid);
        divisionToSave.getAddress().setId(addressId);
    }

}
