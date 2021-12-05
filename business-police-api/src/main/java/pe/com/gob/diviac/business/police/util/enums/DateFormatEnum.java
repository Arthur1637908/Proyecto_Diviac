package pe.com.gob.diviac.business.police.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DateFormatEnum {

    DD_MM_YYYY("dd/MM/yyyy");

    private final String pattern;
}
