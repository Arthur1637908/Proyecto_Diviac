package pe.com.gob.diviac.business.division.adapter.output.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input.SaveDivisionDto;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input.UpdateDivisionDto;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.output.ResponseDivisionDto;

import java.util.List;

@Mapper
public interface DivisionMapper {

    void insert(SaveDivisionDto saveDivisionDto);

    void update(UpdateDivisionDto updateDivisionDto);

    void delete(String id);

    List<ResponseDivisionDto> findAllByCodeAndName(String code, String name, Integer pageSize, Integer currentPage);

    ResponseDivisionDto findById(String id);

    Integer getCountRows(String code, String name);

}
