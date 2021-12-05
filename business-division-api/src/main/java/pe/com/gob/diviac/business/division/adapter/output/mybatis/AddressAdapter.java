package pe.com.gob.diviac.business.division.adapter.output.mybatis;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input.SaveAddressDto;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input.UpdateAddressDto;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.mapper.AddressMapper;
import pe.com.gob.diviac.business.division.domain.port.output.AddressPort;
import pe.com.gob.diviac.business.division.entity.Address;

import java.util.function.Function;

@Slf4j
@Builder
@RequiredArgsConstructor
public class AddressAdapter implements AddressPort {

    private final AddressMapper addressMapper;

    private final Function<Address, SaveAddressDto> saveAddressDtoConverter;
    private final Function<Address, UpdateAddressDto> updateAddressDtoConverter;

    @Override
    public void insert(Address address) {

        log.info("Starting AddressAdapter.insert");

        addressMapper.insert(saveAddressDtoConverter.apply(address));

        log.info("Finish AddressAdapter.insert successfully");
    }

    @Override
    public void update(Address address) {

        log.info("Starting AddressAdapter.update");

        addressMapper.update(updateAddressDtoConverter.apply(address));

        log.info("Finish AddressAdapter.update successfully");
    }

    @Override
    public void delete(Long id) {

        log.info("Starting AddressAdapter.delete");

        addressMapper.delete(id);

        log.info("Finish AddressAdapter.delete successfully");
    }

    @Override
    public Long getSequence() {

        log.info("Starting AddressAdapter.getSequence");

        Long sequence = addressMapper.getSequence();

        log.info("Finish AddressAdapter.getSequence successfully");

        return sequence;


    }
}
