package pe.com.gob.diviac.channel.administration.adapter.output.http.common.client.fallback;

import java.util.UUID;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import pe.com.gob.diviac.adapter.contract.divisionv1.DivisionListRestResponseBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.DivisionRestResponseBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.SaveDivisionRestRequestBusiness;
import pe.com.gob.diviac.adapter.contract.divisionv1.UpdateDivisionRestRequestBusiness;
import pe.com.gob.diviac.channel.administration.adapter.output.http.common.client.DivisionClient;

@Component
public class DivisionFallBack implements FallbackFactory<DivisionClient> {

    @Override
    public DivisionClient create(Throwable cause) {
        return new DivisionClient() {

            @Override
            public DivisionListRestResponseBusiness listDivisionsByCodeAndName(
                    String code, String name, Integer currentPage, Integer pageSize) {
                throw new RuntimeException(cause);
            }

            @Override
            public DivisionRestResponseBusiness getDivision(UUID id) {
                throw new RuntimeException(cause);
            }

            @Override
            public DivisionRestResponseBusiness save(
                    SaveDivisionRestRequestBusiness saveDivisionRestRequestBusiness) {
                throw new RuntimeException(cause);
            }

            @Override
            public DivisionRestResponseBusiness update(
                    UUID id, UpdateDivisionRestRequestBusiness updateDivisionRestRequestBusiness) {
                throw new RuntimeException(cause);
            }

            @Override
            public void delete(UUID id) {
                throw new RuntimeException(cause);
            }
        };
    }
}
