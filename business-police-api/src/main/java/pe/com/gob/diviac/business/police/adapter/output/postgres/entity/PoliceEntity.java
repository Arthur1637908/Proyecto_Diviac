package pe.com.gob.diviac.business.police.adapter.output.postgres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(schema = "administracion", name = "tb_efectivo")
public class PoliceEntity extends AuditEntity {

    @Id
    @Column(name = "vch_id_efectivo")
    private UUID id;

    @Column(name = "vch_cip")
    private String cip;

    @Column(name = "vch_primer_nombre")
    private String firstName;

    @Column(name = "vch_segundo_nombre")
    private String secondName;

    @Column(name = "vch_apellido_paterno")
    private String lastName;

    @Column(name = "vch_apellido_materno")
    private String secondLastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "int_id_cargo")
    private ParameterEntity position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "int_id_grado")
    private ParameterEntity grade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "int_id_sexo")
    private ParameterEntity sex;

    @Column(name = "dtm_fecha_nacimiento")
    private LocalDate dateOfBirth;

    @Column(name = "vch_seudonimo")
    private String pseudonym;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "int_id_estado_civil")
    private ParameterEntity civilStatus;

    @Column(name = "bol_estado")
    private Boolean state;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "police")
    private List<IdentityDocumentEntity> identityDocumentList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "police")
    private List<PoliceDivisionEntity> policeDivisionList;

}
