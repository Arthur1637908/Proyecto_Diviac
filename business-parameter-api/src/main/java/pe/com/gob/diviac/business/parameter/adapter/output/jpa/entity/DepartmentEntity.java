package pe.com.gob.diviac.business.parameter.adapter.output.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(schema = "generales", name = "tb_departamento")
public class DepartmentEntity {

    @Id
    @Column(name = "int_id_departamento")
    private Integer intIdDepartamento;

    @Column(name = "vch_nombre_departamento")
    private String vchNombreDepartamento;

}
