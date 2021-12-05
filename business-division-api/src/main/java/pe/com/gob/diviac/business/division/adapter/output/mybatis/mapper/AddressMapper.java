package pe.com.gob.diviac.business.division.adapter.output.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input.SaveAddressDto;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input.SaveDivisionDto;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input.UpdateAddressDto;

@Mapper
public interface AddressMapper {

    void insert(SaveAddressDto saveAddressDto);

    void update(UpdateAddressDto updateAddressDto);

    void delete(Long id);

    Long getSequence();

}
