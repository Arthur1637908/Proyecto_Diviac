package pe.com.gob.diviac.channel.administration.domain.interactor;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import lombok.extern.slf4j.Slf4j;

import pe.com.gob.diviac.channel.administration.domain.port.input.DivisionUseCase;
import pe.com.gob.diviac.channel.administration.domain.port.output.DivisionPort;
import pe.com.gob.diviac.channel.administration.entity.division.Division;
import pe.com.gob.diviac.channel.administration.entity.division.request.DivisionListRequest;
import pe.com.gob.diviac.channel.administration.entity.division.response.DivisionListResponse;

@Slf4j
@Builder
@RequiredArgsConstructor
public class DivisionInteractor implements DivisionUseCase {

    private final DivisionPort divisionPort;

    @Override
    public DivisionListResponse listDivisionsByCodeAndName(DivisionListRequest divisionListRequest) {
        DivisionListResponse divisionListResponse;

        log.info("Starting DivisionInteractor.listDivisionsByCodeAndName");
        divisionListResponse = divisionPort.findByCodeAndName(divisionListRequest);
        log.info("Finish DivisionInteractor.listDivisionsByCodeAndName successfully");

        return divisionListResponse;
    }

    @Override
    public Division getDivisionDetail(UUID id) {
        Division division;

        log.info("Starting DivisionInteractor.getDivisionDetail");
        division = divisionPort.getDivisionDetail(id);
        log.info("Finish DivisionInteractor.getDivisionDetail successfully");

        return division;
    }

    @Override
    public void save(Division divisionToSave) {
        log.info("Starting DivisionInteractor.save");
        divisionPort.save(divisionToSave);
        log.info("Finish DivisionInteractor.save successfully");
    }

    @Override
    public Division update(Division divisionToUpdate) {
        Division division;

        log.info("Starting DivisionInteractor.update");
        division = divisionPort.update(divisionToUpdate);
        log.info("Finish DivisionInteractor.update successfully");

        return division;
    }

    @Override
    public void delete(UUID id) {
        log.info("Starting DivisionInteractor.update");
        divisionPort.delete(id);
        log.info("Finish DivisionInteractor.update successfully");
    }


}
