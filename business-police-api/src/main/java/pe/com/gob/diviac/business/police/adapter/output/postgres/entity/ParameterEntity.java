package pe.com.gob.diviac.business.police.adapter.output.postgres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(schema = "generales", name = "tb_parametro")
public class ParameterEntity {

    @Id
    @Column(name  = "int_id_parametro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name  = "vch_desc_parametro")
    private String description;

    @Column(name  = "bol_estado")
    private Boolean state;
}
