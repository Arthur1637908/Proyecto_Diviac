package pe.com.gob.diviac.business.division.adapter.output.mybatis;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input.SaveDivisionDto;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input.UpdateDivisionDto;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.output.ResponseDivisionDto;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.mapper.DivisionMapper;
import pe.com.gob.diviac.business.division.domain.port.output.DivisionPort;
import pe.com.gob.diviac.business.division.entity.Division;
import pe.com.gob.diviac.business.division.entity.request.DivisionsListRequest;
import pe.com.gob.diviac.business.division.entity.response.PageResponse;

@Slf4j
@Builder
@RequiredArgsConstructor
public class DivisionAdapter implements DivisionPort {

    private final DivisionMapper divisionMapper;
    private final Function<Division, SaveDivisionDto> saveDivisionDtoConverter;
    private final Function<Division, UpdateDivisionDto> updateDivisionDtoConverter;
    private final Function<ResponseDivisionDto, Division> responseDivisionConverter;

    @Override
    public void insert(Division division) {
        log.info("Starting DivisionAdapter.insert");

        divisionMapper.insert(saveDivisionDtoConverter.apply(division));

        log.info("Finish DivisionAdapter.insert successfully");
    }

    @Override
    public void update(Division division) {
        divisionMapper.update(updateDivisionDtoConverter.apply(division));
    }

    @Override
    public List<Division> findAllByCodeAndName(DivisionsListRequest divisionsListRequest) {
        List<Division> divisionList;
        List<ResponseDivisionDto> responseDivisionDtoList;

        log.info("Starting DivisionAdapter.findAllByCodeAndName");

        responseDivisionDtoList = divisionMapper.findAllByCodeAndName(divisionsListRequest.getCode(),
                divisionsListRequest.getName(), divisionsListRequest.getPageSize(),
                divisionsListRequest.getCurrentPage());
        divisionList = responseDivisionDtoList.stream()
                .map(responseDivisionConverter)
                .collect(Collectors.toList());

        log.info("Finish DivisionAdapter.findAllByCodeAndName successfully");

        return divisionList;
    }

    @Override
    public void delete(UUID divisionId) {
        log.info("Starting DivisionAdapter.delete");

        divisionMapper.delete(divisionId.toString());

        log.info("Finish DivisionAdapter.delete successfully");
    }

    @Override
    public Division findById(UUID divisionId) {
        Division division;
        ResponseDivisionDto responseDivisionDto;

        log.info("Starting DivisionAdapter.findById");

        ResponseDivisionDto response = divisionMapper.findById(divisionId.toString());
        division = responseDivisionConverter.apply(response);

        log.info("Finish DivisionAdapter.findById successfully");

        return division;
    }

    @Override
    public PageResponse getPage(DivisionsListRequest divisionsListRequest) {
        Integer numberOfItems;
        Integer numberOfPages;

        log.info("Starting DivisionAdapter.getPage");

        numberOfItems = divisionMapper.getCountRows(divisionsListRequest.getCode(),
                divisionsListRequest.getName());
        numberOfPages = Double.valueOf(Math.ceil(numberOfItems.doubleValue()/divisionsListRequest.getPageSize().doubleValue())).intValue();

        log.info("Finish DivisionAdapter.getPage successfully");

        return PageResponse.builder()
                .totalNumberOfItems(numberOfItems)
                .numberOfPages(numberOfPages)
                .build();
    }


}
