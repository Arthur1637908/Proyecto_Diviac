package pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(schema = "generales", name = "tb_grupo_parametro")
public class ParameterGroupEntity {

    @Id
    @Column(name = "int_id_grupo")
    private Integer intIdGrupo;

    @Column(name = "vch_cod_grupo")
    private String vchCodGrupo;

    @Column(name = "vch_desc_grupo")
    private String vchDescGrupo;

    @Column(name = "bol_estado")
    private Boolean bolEstado;

}
