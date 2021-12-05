package pe.com.gob.diviac.channel.parameter.adapter.output.http.common.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.com.gob.diviac.adapter.contract.parameterv1.ParameterBusinessResponse;

@FeignClient(value = "business-parameter-api", url = "${feign.client.config.business-parameter-api.base-url}")
public interface ParameterClient {

    @RequestMapping(method = RequestMethod.GET, value = "parameters", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ParameterBusinessResponse> findParametersByGroupCode(@RequestParam("groupCode") String groupCode);
}
