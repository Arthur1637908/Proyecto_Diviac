package pe.com.gob.diviac.business.division.adapter.output.mybatis.converter.input;

import lombok.Builder;
import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.input.UpdateDivisionDto;
import pe.com.gob.diviac.business.division.entity.Division;

import java.util.function.Function;

@Builder
public class UpdateDivisionDtoConverter
        implements Function<Division, UpdateDivisionDto> {

    @Override
    public UpdateDivisionDto apply(Division division) {

        if (division != null) {
            return UpdateDivisionDto.builder()
                    .id(division.getId().toString())
                    .acronym(division.getAcronym())
                    .description(division.getDescription())
                    .email(division.getContact().getEmail())
                    .phoneNumber(division.getContact().getPhoneNumber())
                    .annexNumber(division.getContact().getAnnexNumber())
                    .build();
        }

        return null;
    }
}
