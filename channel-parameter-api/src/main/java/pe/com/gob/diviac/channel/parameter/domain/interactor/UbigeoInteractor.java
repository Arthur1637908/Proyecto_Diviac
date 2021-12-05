package pe.com.gob.diviac.channel.parameter.domain.interactor;

import java.util.List;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import pe.com.gob.diviac.channel.parameter.domain.port.input.UbigeoUseCase;
import pe.com.gob.diviac.channel.parameter.domain.port.output.UbigeoPort;
import pe.com.gob.diviac.channel.parameter.entity.Department;
import pe.com.gob.diviac.channel.parameter.entity.District;
import pe.com.gob.diviac.channel.parameter.entity.Province;

@Slf4j
@Builder
@RequiredArgsConstructor
public class UbigeoInteractor implements UbigeoUseCase {

    private final UbigeoPort ubigeoPort;

    @Override
    public List<Department> findAllDepartments() {
        List<Department> departmentList;

        log.info("Starting UbigeoInteractor.findAllDepartments");
        departmentList = ubigeoPort.findAllDepartments();
        log.info("Finish UbigeoInteractor.findAllDepartments successfully");

        return departmentList;
    }

    @Override
    public List<Province> findProvincesByIdDepartment(Integer departmentId) {
        List<Province> provinceList;

        log.info("Starting UbigeoInteractor.findProvincesByIdDepartment");
        provinceList = ubigeoPort.findProvincesByIdDepartment(departmentId);
        log.info("Finish UbigeoInteractor.findProvincesByIdDepartment successfully");

        return provinceList;
    }

    @Override
    public List<District> findDistrictsByIdProvince(Integer provinceId) {
        List<District> districtList;

        log.info("Starting UbigeoInteractor.findDistrictsByIdProvince");
        districtList = ubigeoPort.findDistrictsByIdProvince(provinceId);
        log.info("Finish UbigeoInteractor.findDistrictsByIdProvince successfully");

        return districtList;
    }
}
