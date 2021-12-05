package pe.com.gob.diviac.support.audit.producer.util;

import org.apache.commons.codec.digest.DigestUtils;

public class SecurityUtils {

    public static String cipherBySha256(String originalString) {
        return DigestUtils.sha256Hex(originalString);
    }
}
