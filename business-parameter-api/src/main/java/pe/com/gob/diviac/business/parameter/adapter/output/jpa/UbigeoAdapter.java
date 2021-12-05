package pe.com.gob.diviac.business.parameter.adapter.output.jpa;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity.DepartmentEntity;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity.DistrictEntity;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity.ProvinceEntity;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.repository.DepartmentRepository;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.repository.DistrictRepository;
import pe.com.gob.diviac.business.parameter.adapter.output.jpa.repository.ProvinceRepository;
import pe.com.gob.diviac.business.parameter.domain.port.output.UbigeoPort;
import pe.com.gob.diviac.business.parameter.entity.Department;
import pe.com.gob.diviac.business.parameter.entity.District;
import pe.com.gob.diviac.business.parameter.entity.Province;

@Slf4j
@Builder
@RequiredArgsConstructor
public class UbigeoAdapter implements UbigeoPort {

    private final DepartmentRepository departmentRepository;
    private final ProvinceRepository provinceRepository;
    private final DistrictRepository districtRepository;

    private final Function<DepartmentEntity, Department> departmentConverter;
    private final Function<ProvinceEntity, Province> provinceConverter;
    private final Function<DistrictEntity, District> districtConverter;

    @Override
    public List<Department> findAllDepartments() {
        List<Department> departmentList;

        log.info("Starting UbigeoAdapter.findAllDepartments");
        departmentList = departmentRepository.findAll().stream()
                .map(departmentConverter)
                .collect(Collectors.toList());
        log.info("Finish UbigeoAdapter.findAllDepartments successfully");

        return departmentList;
    }

    @Override
    public List<Province> findProvincesByIdDepartment(Integer departmentId) {
        List<Province> provinceList;

        log.info("Starting UbigeoAdapter.findProvincesByIdDepartment");
        provinceList = provinceRepository.findAllByIntIdDepartamento(departmentId).stream()
                .map(provinceConverter)
                .collect(Collectors.toList());
        log.info("Finish UbigeoAdapter.findProvincesByIdDepartment successfully");

        return provinceList;
    }

    @Override
    public List<District> findDistrictsByIdProvince(Integer provinceId) {
        List<District> districtList;

        log.info("Starting UbigeoAdapter.findDistrictsByIdProvince");
        districtList = districtRepository.findAllByIntIdProvincia(provinceId).stream()
                .map(districtConverter)
                .collect(Collectors.toList());
        log.info("Finish UbigeoAdapter.findDistrictsByIdProvince successfully");

        return districtList;
    }
}
