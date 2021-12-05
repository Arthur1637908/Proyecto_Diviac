package pe.com.gob.diviac.support.audit.producer.application.kafka.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TopicBean {

    protected String name;
    protected Integer partitions;
    protected Integer replicas;
}
