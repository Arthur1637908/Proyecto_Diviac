package pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(schema = "generales", name = "tb_parametro")
public class ParameterEntity {

    @Id
    @Column(name = "int_id_parametro")
    private Integer intIdParametro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "int_id_grupo")
    private ParameterGroupEntity parameterGroupEntity;

    @Column(name = "vch_desc_parametro")
    private String vchDescParametro;

    @Column(name = "bol_estado")
    private Boolean bolEstado;

}
