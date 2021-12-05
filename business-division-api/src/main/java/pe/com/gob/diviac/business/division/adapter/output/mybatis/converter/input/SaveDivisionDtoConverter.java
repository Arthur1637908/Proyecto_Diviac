package pe.com.gob.diviac.business.division.adapter.output.mybatis.converter.input;

import lombok.Builder;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input.SaveDivisionDto;
import pe.com.gob.diviac.business.division.entity.Division;

import java.util.UUID;
import java.util.function.Function;

@Builder
public class SaveDivisionDtoConverter
        implements Function<Division, SaveDivisionDto> {

    @Override
    public SaveDivisionDto apply(Division division) {

        if (division != null) {
            return SaveDivisionDto.builder()
                    .id(division.getId().toString())
                    .code(division.getCode())
                    .acronym(division.getAcronym())
                    .name(division.getName())
                    .description(division.getDescription())
                    .addressId(division.getAddress().getId())
                    .email(division.getContact().getEmail())
                    .phoneNumber(division.getContact().getPhoneNumber())
                    .annexNumber(division.getContact().getAnnexNumber())
                    .build();
        }

        return null;
    }
}
