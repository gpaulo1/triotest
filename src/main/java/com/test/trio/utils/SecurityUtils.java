package com.test.trio.utils;

import com.test.trio.repository.MailChimpIntegration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtils {

    private static final Logger log = LoggerFactory.getLogger(MailChimpIntegration.class);

    public static String convertMailToMd5(final String mail){

        log.info("Converting mail to md5.");

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            log.error("Error for converting mail to md5.");
            e.printStackTrace();
        }

        md.update(mail.getBytes());
        byte[] digest = md.digest();

        return DatatypeConverter
                .printHexBinary(digest).toUpperCase();
    }

}
