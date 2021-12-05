package pe.com.gob.diviac.channel.parameter.adapter.output.http.ubigeo;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import pe.com.gob.diviac.adapter.contract.parameterv1.DepartmentBusinessResponse;
import pe.com.gob.diviac.adapter.contract.parameterv1.DistrictBusinessResponse;
import pe.com.gob.diviac.adapter.contract.parameterv1.ProvinceBusinessResponse;
import pe.com.gob.diviac.channel.parameter.adapter.output.http.common.client.UbigeoClient;
import pe.com.gob.diviac.channel.parameter.domain.port.output.UbigeoPort;
import pe.com.gob.diviac.channel.parameter.entity.Department;
import pe.com.gob.diviac.channel.parameter.entity.District;
import pe.com.gob.diviac.channel.parameter.entity.Province;

@Slf4j
@Builder
@RequiredArgsConstructor
public class UbigeoAdapter implements UbigeoPort {

    private final UbigeoClient ubigeoClient;

    private final Function<DepartmentBusinessResponse, Department> departmentConverter;
    private final Function<ProvinceBusinessResponse, Province> provinceConverter;
    private final Function<DistrictBusinessResponse, District> districtConverter;

    @Override
    public List<Department> findAllDepartments() {
        List<Department> departmentList;

        log.info("Starting UbigeoAdapter.findAllDepartments");
        departmentList = ubigeoClient.findAllDepartments()
                .stream()
                .map(departmentConverter)
                .collect(Collectors.toList());
        log.info("Finish UbigeoAdapter.findAllDepartments successfully");

        return departmentList;
    }

    @Override
    public List<Province> findProvincesByIdDepartment(Integer departmentId) {
        List<Province> provinceList;

        log.info("Starting UbigeoAdapter.findProvincesByIdDepartment");
        provinceList = ubigeoClient.findProvincesByIdDepartment(departmentId)
                .stream()
                .map(provinceConverter)
                .collect(Collectors.toList());
        log.info("Finish UbigeoAdapter.findProvincesByIdDepartment successfully");

        return provinceList;
    }

    @Override
    public List<District> findDistrictsByIdProvince(Integer provinceId) {
        List<District> districtList;

        log.info("Starting UbigeoAdapter.findDistrictsByIdProvince");
        districtList = ubigeoClient.findDistrictsByIdProvince(provinceId)
                .stream()
                .map(districtConverter)
                .collect(Collectors.toList());
        log.info("Finish UbigeoAdapter.findDistrictsByIdProvince successfully");

        return districtList;
    }
}
