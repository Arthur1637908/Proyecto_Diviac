package pe.com.gob.diviac.business.police.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SituationTypeEnum {

    HOLIDAYS(19, "VACACIONES"),
    PERMIT(20, "PERMISO"),
    SUB_UNIT_SUPPORT(21, "APOYO SUB UNIDAD"),
    COMMISSION(22, "COMISION"),
    LICENSE(23, "LICENCIAS"),
    MATERNITY(24, "MATERNIDAD"),
    PATERNITY(25, "PATERNIDAD"),
    DEATH(26, "FALLECIMIENTO"),
    ADOPTION(27, "ADOPCION"),
    ISOLATED_BY_COVID(28, "AISLADO POR COVID"),
    REMOTE_WORK(29, "TRABAJO REMOTO");

    private final Integer id;
    private final String description;
}
