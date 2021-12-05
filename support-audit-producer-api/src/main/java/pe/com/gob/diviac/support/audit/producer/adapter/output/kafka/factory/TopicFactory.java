package pe.com.gob.diviac.support.audit.producer.adapter.output.kafka.factory;

import pe.com.gob.diviac.support.audit.producer.application.kafka.bean.TopicBean;

public interface TopicFactory {

    TopicBean createInstance();
}
