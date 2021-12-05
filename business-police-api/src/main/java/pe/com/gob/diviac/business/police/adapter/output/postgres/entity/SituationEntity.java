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
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(schema = "administracion", name = "tb_situacion")
public class SituationEntity extends AuditEntity {

    @Id
    @Column(name = "int_id_situacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vch_id_efectivo")
    private PoliceEntity police;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "int_id_tipo_situacion")
    private ParameterEntity situationType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vch_id_division")
    private DivisionEntity division;

    @Column(name = "dtm_fecha_inicio")
    private LocalDate startDate;

    @Column(name = "dtm_fecha_termino")
    private LocalDate endDate;

    @Column(name = "vch_nombre_sustento")
    private String documentName;

    @Column(name = "vch_ruta_sustento")
    private String documentPath;

    @Column(name = "bol_estado")
    private Boolean state;
}
