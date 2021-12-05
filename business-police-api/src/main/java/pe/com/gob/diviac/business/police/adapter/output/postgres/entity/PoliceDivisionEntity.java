package pe.com.gob.diviac.business.police.adapter.output.postgres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(schema = "administracion", name = "tb_division_tb_efectivo")
public class PoliceDivisionEntity extends AuditEntity{

    @Id
    @Column(name = "int_id_division_efectivo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vch_id_division")
    private DivisionEntity division;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vch_id_efectivo")
    private PoliceEntity police;

    @Column(name = "bol_estado")
    private Boolean state;
}
