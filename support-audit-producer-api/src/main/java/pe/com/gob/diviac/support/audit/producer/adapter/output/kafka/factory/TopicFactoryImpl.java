package pe.com.gob.diviac.support.audit.producer.adapter.output.kafka.factory;

import lombok.Builder;

import pe.com.gob.diviac.support.audit.producer.application.kafka.bean.AdministrationTopicBean;
import pe.com.gob.diviac.support.audit.producer.application.kafka.bean.CriminalInvestigationTopicBean;
import pe.com.gob.diviac.support.audit.producer.application.kafka.bean.DefaultTopicBean;
import pe.com.gob.diviac.support.audit.producer.application.kafka.bean.SpecialsResourcesTopicBean;
import pe.com.gob.diviac.support.audit.producer.application.kafka.bean.TopicBean;

@Builder
public class TopicFactoryImpl implements TopicFactory {

    private final DefaultTopicBean defaultTopicBean;
    private final AdministrationTopicBean administrationTopicBean;
    private final SpecialsResourcesTopicBean specialsResourcesTopicBean;
    private final CriminalInvestigationTopicBean criminalInvestigationTopicBean;

    @Override
    public TopicBean createInstance() {
        return defaultTopicBean;
    }
}
