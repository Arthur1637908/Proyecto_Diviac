package pe.com.gob.diviac.business.police.util;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicMatch;
import org.springframework.web.multipart.MultipartFile;
import pe.com.gob.diviac.business.police.util.enums.FileExtensionEnum;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

@Slf4j
public class FileUtils {

    public static boolean isValidFileExtension(MultipartFile file) {
        String fileExtension;
        FileExtensionEnum fileExtensionEnum;

        try {
            fileExtension = findFileExtension(file);
            fileExtensionEnum = FileExtensionEnum.getEnum(fileExtension);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }

        return Objects.nonNull(fileExtensionEnum);
    }

    @SneakyThrows
    private static String findFileExtension(MultipartFile file)
            throws IOException {
        byte[] data = file.getBytes();
        MagicMatch match = Magic.getMagicMatch(data);

        return match.getMimeType();
    }
}
