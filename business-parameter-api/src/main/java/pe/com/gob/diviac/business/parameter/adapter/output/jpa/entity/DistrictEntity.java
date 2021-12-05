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
@Table(schema = "generales", name = "tb_distrito")
public class DistrictEntity {

    @Id
    @Column(name = "int_id_distrito")
    private Integer intIdDistrito;

    @Column(name = "int_id_provincia")
    private Integer intIdProvincia;

    @Column(name = "vch_nombre_distrito")
    private String vchNombreDistrito;

}
