package pe.com.gob.diviac.support.audit.producer.application.kafka.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "spring.kafka.topics.default")
public class DefaultTopicBean extends TopicBean {
}
