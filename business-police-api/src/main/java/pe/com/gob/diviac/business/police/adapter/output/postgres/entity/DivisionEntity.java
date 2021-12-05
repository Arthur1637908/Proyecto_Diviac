package pe.com.gob.diviac.business.police.adapter.output.postgres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(schema = "administracion", name = "tb_division")
public class DivisionEntity {

    @Id
    @Column(name = "vch_id_division")
    private UUID id;

    @Column(name = "vch_cod_division")
    private String code;

    @Column(name = "vch_siglas")
    private String acronym;

    @Column(name = "vch_nombre_division")
    private String name;

    @Column(name = "vch_desc_division")
    private String description;

    @Column(name = "bol_estado")
    private Boolean state;
}
