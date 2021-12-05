package pe.com.gob.diviac.business.police.adapter.output.postgres.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class AuditEntity {

    @Column(name = "vch_usuario_creacion")
    private String creationUserId;

    @Column(name = "dtm_fecha_creacion")
    private LocalDateTime creationDateTime;

    @Column(name = "int_rol_usuario_creacion")
    private Integer creationUserRoleId;

    @Column(name = "vch_usuario_modificacion")
    private String updateUserId;

    @Column(name = "dtm_fecha_modificacion")
    private LocalDateTime updateDateTime;

    @Column(name = "int_rol_usuario_modificacion")
    private Integer updateUserRoleId;

    @PrePersist
    public void setCreationDateTime() {
        this.creationDateTime = LocalDateTime.now();
    }

    @PreUpdate
    public void setUpdateDateTime() {
        this.updateDateTime = LocalDateTime.now();
    }
}
