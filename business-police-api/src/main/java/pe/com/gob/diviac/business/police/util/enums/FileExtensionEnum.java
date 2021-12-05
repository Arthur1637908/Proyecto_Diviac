package pe.com.gob.diviac.business.police.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FileExtensionEnum {

    PDF_EXT("application/pdf"),
    PNG_EXT("image/jpeg"),
    JPG("image/jpeg"),
    JPEG("image/jpeg");

    private final String extension;

    public static FileExtensionEnum getEnum(String extension) {
        for(FileExtensionEnum fileExtensionEnum : FileExtensionEnum.values()) {
            if (fileExtensionEnum.getExtension().equals(extension)) {
                return fileExtensionEnum;
            }
        }

        return null;
    }
}
