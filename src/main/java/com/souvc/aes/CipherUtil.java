package com.souvc.aes;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.*;

/**
 * CipherUtil
 */
public class CipherUtil {

    private static final int KEY_SIZE = 512;

    public static Key getSecretKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = new SecureRandom();
            keyGenerator.init(secureRandom);
            Key key = keyGenerator.generateKey();
            return key;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encrypt(Key key, String text) {
        int mode = Cipher.ENCRYPT_MODE;
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(mode, key);
            int blockSize = cipher.getBlockSize();
            byte[] inBytes = text.getBytes();
            byte[] outBytes = cipher.doFinal(inBytes);
            return new BASE64Encoder().encode(outBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    public static String decrypt(Key key, String text) {
        int mode = Cipher.DECRYPT_MODE;
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(mode, key);
            int blockSize = cipher.getBlockSize();
            byte[] inBytes = new BASE64Decoder().decodeBuffer(text);
            byte[] outBytes = cipher.doFinal(inBytes);
            return new String(outBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static KeyPair getRSAKey() {
        try {
            KeyPairGenerator pairGenerator = KeyPairGenerator.getInstance("RSA");
            SecureRandom secureRandom = new SecureRandom();
            pairGenerator.initialize(KEY_SIZE, secureRandom);
            KeyPair keyPair = pairGenerator.generateKeyPair();
            return keyPair;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encryptPublicKey(KeyPair keyPair, Key key, String text) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.WRAP_MODE, keyPair.getPublic());
            byte[] keyBytes = cipher.wrap(key);
            byte[] inBytes = text.getBytes();
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            os.write(keyBytes.length);
            System.out.println(keyBytes.length + "XXXXX");
            os.write(keyBytes);
            os.write(inBytes);
            byte[] outBytes = cipher.doFinal(os.toByteArray());
            return new BASE64Encoder().encode(outBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    public static String decryptPublicKey(KeyPair keyPair, String text) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.UNWRAP_MODE, keyPair.getPrivate());
            byte[] inBytes = new BASE64Decoder().decodeBuffer(text);
            ByteArrayInputStream is = new ByteArrayInputStream(inBytes);
            int length = is.read();
            byte[] keyBytes = new byte[length];
            is.read(keyBytes, 0, length);
            System.out.println(length + "XXX");
            Key key = cipher.unwrap(keyBytes, "AES", Cipher.SECRET_KEY);

            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] outBytes = new byte[is.available()];
            is.read(outBytes);
            return new String(outBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
//        Key key =  getSecretKey();
//        String text = "fengdui";
//        String encode = encrypt(key, text);
//        System.out.println(encode);
//        String decode = decrypt(key, encode);
//        System.out.println(decode);
        KeyPair keyPair = getRSAKey();
        Key key = getSecretKey();
        String text = "fengdui";
        String encode = encryptPublicKey(keyPair, key, text);
        System.out.println(encode);
        String decode = decryptPublicKey(keyPair, encode);
        System.out.println(decode);
    }
}