package pe.com.gob.diviac.channel.administration.adapter.output.http.common.client;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.com.gob.diviac.adapter.contract.divisionv1.DivisionListRestResponseBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.DivisionRestResponseBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.SaveDivisionRestRequestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.UpdateDivisionRestRequestBusiness;
import pe.com.gob.diviac.channel.administration.adapter.output.http.common.client.fallback.DivisionFallBack;

@FeignClient(value = "business-division-api", url = "${feign.client.config.business-division-api.base-url}",
        fallbackFactory = DivisionFallBack.class)
public interface DivisionClient {

    @RequestMapping(method = RequestMethod.GET, value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    DivisionListRestResponseBusiness listDivisionsByCodeAndName(@RequestParam("code") String code,
                                                                @RequestParam("name") String name,
                                                                @RequestParam("currentPage") Integer currentPage,
                                                                @RequestParam("pageSize") Integer pageSize);

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    DivisionRestResponseBusiness getDivision(@PathVariable("id") UUID id);

    @RequestMapping(method = RequestMethod.POST, value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    DivisionRestResponseBusiness save(SaveDivisionRestRequestBusiness saveDivisionRestRequestBusiness);

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    DivisionRestResponseBusiness update(@PathVariable("id") UUID id,
                                        UpdateDivisionRestRequestBusiness updateDivisionRestRequestBusiness);

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("id") UUID id);
}
