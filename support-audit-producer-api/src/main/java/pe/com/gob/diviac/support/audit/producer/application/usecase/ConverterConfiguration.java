package pe.com.gob.diviac.support.audit.producer.application.usecase;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pe.com.gob.diviac.support.audit.producer.adapter.input.web.converter.request.AuditRestRequestConverter;
import pe.com.gob.diviac.support.audit.producer.adapter.input.web.model.request.AuditRestRequest;
import pe.com.gob.diviac.support.audit.producer.entity.Audit;

@Configuration
public class ConverterConfiguration {

    @Bean
    public Function<AuditRestRequest, Audit> producerRestRequestConverter() {
        return AuditRestRequestConverter.builder()
                .build();
    }
}
