package pe.com.gob.diviac.business.division.adapter.output.mybatis.converter.output;

import lombok.Builder;

import java.util.UUID;
import java.util.function.Function;

import pe.com.gob.diviac.business.division.adapter.output.mybatis.alias.output.ResponseDivisionDto;
import pe.com.gob.diviac.business.division.entity.*;

@Builder
public class ResponseDivisionConverter
        implements Function<ResponseDivisionDto, Division> {

    @Override
    public Division apply(ResponseDivisionDto responseDivisionDto) {

        if (responseDivisionDto != null) {
            return Division.builder()
                    .id(UUID.fromString(responseDivisionDto.getId()))
                    .code(responseDivisionDto.getCode())
                    .acronym(responseDivisionDto.getAcronym())
                    .name(responseDivisionDto.getName())
                    .description(responseDivisionDto.getDescription())
                    .address(buildAddress(responseDivisionDto))
                    .contact(buildContact(responseDivisionDto))
                    .build();
        }

        return null;
    }

    private Address buildAddress(ResponseDivisionDto responseDivisionDto) {

        return Address.builder()
                .id(responseDivisionDto.getAddressId())
                .name(responseDivisionDto.getAddressName())
                .number(responseDivisionDto.getAddressNumber())
                .type(buildType(responseDivisionDto))
                .district(buildDistrict(responseDivisionDto))
                .province(buildProvince(responseDivisionDto))
                .ubigeo(buildDepartment(responseDivisionDto))
                .build();

    }

    private Parameter buildType(ResponseDivisionDto responseDivisionDto) {
        return Parameter.builder()
                .id(responseDivisionDto.getAddressTypeId())
                .name(responseDivisionDto.getAddressTypeName())
                .build();
    }

    private Ubigeo buildDistrict(ResponseDivisionDto responseDivisionDto) {
        return Ubigeo.builder()
                .id(responseDivisionDto.getAddressDistrictId())
                .name(responseDivisionDto.getAddressDistrictName())
                .build();
    }

    private Ubigeo buildProvince(ResponseDivisionDto responseDivisionDto) {
        return Ubigeo.builder()
                .id(responseDivisionDto.getAddressProvinceId())
                .name(responseDivisionDto.getAddressProvinceName())
                .build();
    }

    private Ubigeo buildDepartment(ResponseDivisionDto responseDivisionDto) {
        return Ubigeo.builder()
                .id(responseDivisionDto.getAddressDepartmentId())
                .name(responseDivisionDto.getAddressDepartmentName())
                .build();
    }

    private Contact buildContact(ResponseDivisionDto responseDivisionDto) {
        return Contact.builder()
                .email(responseDivisionDto.getEmail())
                .phoneNumber(responseDivisionDto.getPhoneNumber())
                .annexNumber(responseDivisionDto.getAnnexNumber())
                .build();
    }

}
