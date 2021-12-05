package pe.com.gob.diviac.support.audit.producer.application.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import pe.com.gob.diviac.support.audit.producer.adapter.output.kafka.factory.TopicFactory;
import pe.com.gob.diviac.support.audit.producer.adapter.output.kafka.factory.TopicFactoryImpl;
import pe.com.gob.diviac.support.audit.producer.application.kafka.bean.AdministrationTopicBean;
import pe.com.gob.diviac.support.audit.producer.application.kafka.bean.CriminalInvestigationTopicBean;
import pe.com.gob.diviac.support.audit.producer.application.kafka.bean.DefaultTopicBean;
import pe.com.gob.diviac.support.audit.producer.application.kafka.bean.SpecialsResourcesTopicBean;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public TopicFactory topicFactory(DefaultTopicBean defaultTopicBean,
                                     AdministrationTopicBean administrationTopicBean,
                                     SpecialsResourcesTopicBean specialsResourcesTopicBean,
                                     CriminalInvestigationTopicBean criminalInvestigationTopicBean) {
        return TopicFactoryImpl.builder()
                .defaultTopicBean(defaultTopicBean)
                .administrationTopicBean(administrationTopicBean)
                .specialsResourcesTopicBean(specialsResourcesTopicBean)
                .criminalInvestigationTopicBean(criminalInvestigationTopicBean)
                .build();
    }

    @Bean
    public NewTopic defaultTopic(DefaultTopicBean defaultTopicBean) {
        return TopicBuilder
                .name(defaultTopicBean.getName())
                .partitions(defaultTopicBean.getPartitions())
                .replicas(defaultTopicBean.getPartitions())
                .build();
    }

    @Bean
    public NewTopic administrationTopic(AdministrationTopicBean administrationTopicBean) {
        return TopicBuilder
                .name(administrationTopicBean.getName())
                .partitions(administrationTopicBean.getPartitions())
                .replicas(administrationTopicBean.getReplicas())
                .build();
    }

    @Bean
    public NewTopic specialsResourcesTopics(SpecialsResourcesTopicBean specialsResourcesTopicBean) {
        return TopicBuilder
                .name(specialsResourcesTopicBean.getName())
                .partitions(specialsResourcesTopicBean.getPartitions())
                .replicas(specialsResourcesTopicBean.getReplicas())
                .build();
    }

    @Bean
    public NewTopic criminalInvestigationTopics(CriminalInvestigationTopicBean criminalInvestigationTopicBean) {
        return TopicBuilder
                .name(criminalInvestigationTopicBean.getName())
                .partitions(criminalInvestigationTopicBean.getPartitions())
                .replicas(criminalInvestigationTopicBean.getReplicas())
                .build();
    }
}
