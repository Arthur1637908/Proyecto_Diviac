package pe.com.gob.diviac.channel.parameter.adapter.output.http.common.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.com.gob.diviac.adapter.contract.parameterv1.DepartmentBusinessResponse;
import pe.com.gob.diviac.adapter.contract.parameterv1.DistrictBusinessResponse;
import pe.com.gob.diviac.adapter.contract.parameterv1.ProvinceBusinessResponse;


@FeignClient(value = "business-parameter-api", url = "${feign.client.config.business-parameter-api.base-url}")
public interface UbigeoClient {

    @RequestMapping(method = RequestMethod.GET, value = "ubigeos/departments",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<DepartmentBusinessResponse> findAllDepartments();

    @RequestMapping(method = RequestMethod.GET, value = "ubigeos/provinces",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProvinceBusinessResponse> findProvincesByIdDepartment(@RequestParam("departmentId") Integer departmentId);

    @RequestMapping(method = RequestMethod.GET, value = "ubigeos/districts",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<DistrictBusinessResponse> findDistrictsByIdProvince(@RequestParam("provinceId") Integer provinceId);
}
