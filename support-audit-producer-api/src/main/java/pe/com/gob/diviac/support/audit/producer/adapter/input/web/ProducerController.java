package pe.com.gob.diviac.support.audit.producer.adapter.input.web;

import java.util.function.Function;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.gob.diviac.support.audit.producer.adapter.input.web.model.request.AuditRestRequest;
import pe.com.gob.diviac.support.audit.producer.domain.port.input.ProducerUseCase;
import pe.com.gob.diviac.support.audit.producer.entity.Audit;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/producers")
public class ProducerController {

    private final ProducerUseCase producerUseCase;
    private final Function<AuditRestRequest, Audit> producerRestRequestConverter;

    @PostMapping(value = "/send", produces = MediaType.APPLICATION_JSON_VALUE)
    public void sendMessage(@Valid @RequestBody AuditRestRequest auditRestRequest) {
        Audit audit = producerRestRequestConverter.apply(auditRestRequest);
        producerUseCase.produceAuditMessage(audit);
    }
}
