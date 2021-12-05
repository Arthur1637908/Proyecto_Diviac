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
@Table(schema = "generales", name = "tb_provincia")
public class ProvinceEntity {

    @Id
    @Column(name = "int_id_provincia")
    private Integer intIdProvincia;

    @Column(name = "int_id_departamento")
    private Integer intIdDepartamento;

    @Column(name = "vch_nombre_provincia")
    private String vchNombreProvincia;

}
