package com.bookstore.dao;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {
    public HashGenerator() {

    }

    public static String generateMD5(String message) throws HashGenerationException {
        return hashString(message, "MD5");
    }

    private static String hashString(String message, String algorithm) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            byte[] hasedBytes = digest.digest(message.getBytes("UTF-8"));

            return convertByteArrayToHexString(hasedBytes);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            throw new HashGenerationException("Could not generate hash from string", ex);
        }
    }

    private static String convertByteArrayToHexString(byte[] arrayBytes) {

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayBytes.length; i++) {
            stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return stringBuffer.toString();
    }
}
