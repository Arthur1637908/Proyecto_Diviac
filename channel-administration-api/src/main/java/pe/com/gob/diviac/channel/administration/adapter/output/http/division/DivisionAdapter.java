package pe.com.gob.diviac.channel.administration.adapter.output.http.division;

import java.util.UUID;
import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import pe.com.gob.diviac.adapter.contract.divisionv1.DivisionListRestResponseBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.DivisionRestResponseBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.SaveDivisionRestRequestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.UpdateDivisionRestRequestBusiness;
import pe.com.gob.diviac.channel.administration.adapter.output.http.common.client.DivisionClient;
import pe.com.gob.diviac.channel.administration.domain.port.output.DivisionPort;
import pe.com.gob.diviac.channel.administration.entity.division.Division;
import pe.com.gob.diviac.channel.administration.entity.division.request.DivisionListRequest;
import pe.com.gob.diviac.channel.administration.entity.division.response.DivisionListResponse;

@Slf4j
@Builder
@RequiredArgsConstructor
public class DivisionAdapter implements DivisionPort {

    private final DivisionClient divisionClient;

    private final Function<Division, SaveDivisionRestRequestBusiness> saveDivisionRestRequestBusinessConverter;
    private final Function<Division, UpdateDivisionRestRequestBusiness> updateDivisionRestRequestBusinessConverter;

    private final Function<DivisionListRestResponseBusiness, DivisionListResponse> divisionListResponseConverter;
    private final Function<DivisionRestResponseBusiness, Division> divisionConverter;

    @Override
    public DivisionListResponse findByCodeAndName(DivisionListRequest divisionListRequest) {
        DivisionListRestResponseBusiness divisionListRestResponseBusiness;
        DivisionListResponse divisionListResponse;

        log.info("Starting DivisionAdapter.listDivisionsByCodeAndName");
        divisionListRestResponseBusiness = divisionClient.listDivisionsByCodeAndName(
                divisionListRequest.getCode(), divisionListRequest.getName(),
                divisionListRequest.getCurrentPage(),divisionListRequest.getPageSize());
        divisionListResponse = divisionListResponseConverter.apply(divisionListRestResponseBusiness);
        log.info("Finish DivisionAdapter.listDivisionsByCodeAndName successfully");

        return divisionListResponse;
    }

    @Override
    public Division getDivisionDetail(UUID id) {
        DivisionRestResponseBusiness divisionRestResponseBusiness;
        Division division;

        log.info("Starting DivisionAdapter.getDivisionDetail");
        divisionRestResponseBusiness = divisionClient.getDivision(id);
        division = divisionConverter.apply(divisionRestResponseBusiness);
        log.info("Finish DivisionAdapter.getDivisionDetail successfully");

        return division;
    }

    @Override
    public void save(Division divisionToSave) {
        SaveDivisionRestRequestBusiness saveDivisionRestRequestBusiness;

        log.info("Starting DivisionAdapter.save");
        saveDivisionRestRequestBusiness = saveDivisionRestRequestBusinessConverter.apply(divisionToSave);
        divisionClient.save(saveDivisionRestRequestBusiness);
        log.info("Finish DivisionAdapter.save successfully");
    }

    @Override
    public Division update(Division divisionToUpdate) {
        UpdateDivisionRestRequestBusiness updateDivisionRestRequestBusiness;
        DivisionRestResponseBusiness divisionRestResponseBusiness;
        Division division;

        log.info("Starting DivisionAdapter.update");
        updateDivisionRestRequestBusiness = updateDivisionRestRequestBusinessConverter.apply(divisionToUpdate);
        divisionRestResponseBusiness = divisionClient.update(divisionToUpdate.getId(),
                updateDivisionRestRequestBusiness);
        division = divisionConverter.apply(divisionRestResponseBusiness);
        log.info("Finish DivisionAdapter.update successfully");

        return division;
    }

    @Override
    public void delete(UUID id) {
        log.info("Starting DivisionAdapter.delete");
        divisionClient.delete(id);
        log.info("Finish DivisionAdapter.delete successfully");
    }
}
