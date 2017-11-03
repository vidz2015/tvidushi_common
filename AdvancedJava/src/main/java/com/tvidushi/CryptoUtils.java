/**
 *
 */
package com.spacetimeinsight.magma.server.security.util;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.enterprisehorizons.exception.EHRuntimeException;
import com.enterprisehorizons.util.FileUtils;
import com.enterprisehorizons.util.Logger;
import com.enterprisehorizons.util.StringUtils;

import de.schlichtherle.util.ObfuscatedString;

/**
 *
 * An Utility class to handle Encryption/Decryption for the required content
 *
 * The algorithm used for Encrypt/Decrypt is DESede {Triple-DES�a} with mode of
 * encoding is Chained Block Cipher(CBC), which works with a special array of
 * data called an initialization vector (IV) and then encrypt the combined data.
 *
 * The current class can take either content or filename as input to produce the
 * desired output of encryption or decryption...
 *
 * @author Shreekanth
 */
public class CryptoUtils {

	// Base64Encoder...helps in ASCII handlings...
//	private static BASE64Encoder base64Encoder = new BASE64Encoder();

//	private static BASE64Decoder base64Decoder = new BASE64Decoder();

	// Create an initialization vector (necessary for CBC mode) 
	// Most modes require a unique binary sequence, often called an initialization vector (IV
	private static IvParameterSpec IvParameters = new IvParameterSpec(new byte[] { 12, 34, 56, 78, 90, 87, 65, 43 });

	// A default key to be used for encryption to be used
	private static String DEFAULT_MAGMA_ENCRYPTED_KEY = new ObfuscatedString(new long[] { 0x3C02FD934EE59636L, 0x2524189F4CCD74C3L,
			0x12F4B0C4A14068FEL, 0x6B4A81E2AD590A8BL, 0x9BF68D04C2132687L }).toString();
	// A default key to be used for encryption to be used
	private static String DEFAULT_MAGMA_DECRYPTED_KEY = new ObfuscatedString(new long[] { 0x3C02FD934EE59636L, 0x2524189F4CCD74C3L,
			0x12F4B0C4A14068FEL, 0x6B4A81E2AD590A8BL, 0x9BF68D04C2132687L }).toString();

	private static String ASCII = "ASCII";

	private static String SECRET_KEY_DESEDE = "DESede";

	private static String CIPHER_KEY_PROVIDER = "SunJCE";

	private static String CIPHER_TRANSFORMATION = "DESede/CBC/PKCS5Padding";

	/**
	 * returns the encrypted content for the input filename
	 *
	 * @param fileNameWithPath
	 * @return
	 * @throws java.security.InvalidKeyException
	 * @throws Exception
	 */
	public static String encryptFile(String fileNameWithPath) throws java.security.InvalidKeyException, Exception {
		if (fileNameWithPath != null) {
			String fileContent = FileUtils.getContent(fileNameWithPath);
			if (fileContent != null) {
				return encrypt(null, fileContent);
			}
		}
		return null;
	}

	/**
	 * returns the decrypted content for the input filename
	 *
	 * @param fileNameWithPath
	 * @return
	 * @throws java.security.InvalidKeyException
	 * @throws Exception
	 */
	public static  String decryptFile(String fileNameWithPath) throws java.security.InvalidKeyException, Exception {
		if (fileNameWithPath != null) {
			String fileContent = FileUtils.getContent(fileNameWithPath);
			if (fileContent != null) {
				return decrypt(null, fileContent);
			}
		}
		return null;
	}

	/**
	 *
	 * returns the encrypted content for the input filename based on the key
	 * passed for encryption
	 *
	 * @param keyToEncrypt
	 * @param fileNameWithPath
	 * @return
	 * @throws java.security.InvalidKeyException
	 * @throws Exception
	 */
	public static String encryptFile(String keyToEncrypt, String fileNameWithPath) throws java.security.InvalidKeyException, Exception {
		if (fileNameWithPath != null) {
			String fileContent = FileUtils.getContent(fileNameWithPath);
			if (fileContent != null) {
				return encrypt(keyToEncrypt, fileContent);
			}
		}
		return null;
	}

	/**
	 *
	 * returns the decrypted content for the input filename based on the key
	 * passed for decryption
	 *
	 * @param keyToDencrypt
	 * @param fileNameWithPath
	 * @return
	 * @throws java.security.InvalidKeyException
	 * @throws Exception
	 */
	public static String decryptFile(String keyToDencrypt, String fileNameWithPath) throws java.security.InvalidKeyException, Exception {
		if (fileNameWithPath != null) {
			String fileContent = FileUtils.getContent(fileNameWithPath);
			if (fileContent != null) {
				return decrypt(keyToDencrypt, fileContent);
			}
		}
		return null;
	}

	/**
	 * encrypts the source data
	 *
	 * @param keyToEncrypt
	 * @param sourceTextData
	 * @return
	 */
	public static String encrypt(String keyToEncrypt, String sourceTextData) {

		String encryptedData = null;
		if (sourceTextData != null) {

			try {
				Security.addProvider(new com.sun.crypto.provider.SunJCE());

				// Create an array to hold the key
				byte[] byteKeyToEncrypt = null;

				if (keyToEncrypt != null) {
					byteKeyToEncrypt = keyToEncrypt.getBytes(ASCII);
				} else {
					// handle with defaultKey
					byteKeyToEncrypt = DEFAULT_MAGMA_ENCRYPTED_KEY.getBytes(ASCII);
				}

				// Create a DESede key spec from the key
				DESedeKeySpec spec = new DESedeKeySpec(byteKeyToEncrypt);

				// Get the secret key factor for generating DESede keys
				SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(SECRET_KEY_DESEDE);

				// Generate a DESede SecretKey object
				SecretKey theKey = keyFactory.generateSecret(spec);

				// Create a DESede Cipher
				Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION, CIPHER_KEY_PROVIDER);

				// Initialize the cipher and put it into encrypt mode
				cipher.init(Cipher.ENCRYPT_MODE, theKey, IvParameters);

				byte[] bytePlainText = sourceTextData.getBytes(ASCII);

				// Encrypt the data
				byte[] encryptedBytes = cipher.doFinal(bytePlainText);

				if (encryptedBytes != null) {
					BASE64Encoder base64Encoder = new BASE64Encoder();
					encryptedData = base64Encoder.encode(encryptedBytes);
				}

			} catch (Exception e) {
				throw new EHRuntimeException(e);
			}
		}
		return encryptedData;
	}

	/**
	 * returns the decrypted content for the input encrypted content
	 *
	 * @param keyToDecrypt
	 * @param encryptedText
	 * @return
	 */
	public static String decrypt(String keyToDecrypt, String encryptedText) {
		String decryptedData = encryptedText;
	//	Logger.warn("-------encryptedText :"+encryptedText,CryptoUtils.class);
		if (!StringUtils.isNull(encryptedText)) {
			try {
				// makes sure Sun JCE is the provider
				Security.addProvider(new com.sun.crypto.provider.SunJCE());

				// Create an array to hold the key
				byte[] byteKeyToDecrypt = null;

				if (keyToDecrypt != null) {
					byteKeyToDecrypt = keyToDecrypt.getBytes(ASCII);
				} else {
					byteKeyToDecrypt = DEFAULT_MAGMA_DECRYPTED_KEY.getBytes(ASCII);
				}

				// Create a DESede key spec from the key
				DESedeKeySpec spec = new DESedeKeySpec(byteKeyToDecrypt);

				// Get the secret key factor for generating DESede keys
				SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(SECRET_KEY_DESEDE);

				// Generate a DESede SecretKey object
				SecretKey theKey = keyFactory.generateSecret(spec);

				// Create a DESede Cipher
				Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION, CIPHER_KEY_PROVIDER);

				// Initialize the cipher and put it in decrypt mode
				cipher.init(Cipher.DECRYPT_MODE, theKey, IvParameters);
				//Logger.warn("-------encryptedText :"+encryptedText+"\t byteKeyToDecrypt :"+byteKeyToDecrypt,CryptoUtils.class);
				BASE64Decoder base64Decoder = new BASE64Decoder();
				byte[] encryptedByteText = base64Decoder.decodeBuffer(encryptedText);

				// Decrypt the data
				byte[] plainTextBytes = cipher.doFinal(encryptedByteText);

				decryptedData = new String(plainTextBytes, ASCII);

			} catch (Exception e) {
				//throw new EHRuntimeException(e);
				Logger.error(" decryption of the password is failing", CryptoUtils.class, e);
			}
		}
		return decryptedData;
	}

	public static void main(String st[]) {
		try {

			String results = "";
			if (st != null && st.length == 2) {
				if (st[0] == null || st[0].trim().length() == 0 || st[1] == null || st[1].trim().length() == 0) {
					displayUsageMessage();
				}
				if ("encrypt".equalsIgnoreCase(st[0])) {
					results = CryptoUtils.encrypt(null, st[1]);
				} else if ("decrypt".equalsIgnoreCase(st[0])) {
					results = CryptoUtils.decrypt(null, st[1]);
				}
				//System.out.println("Copy below result");
				if (results.trim().length() > 0) {
					System.out.println(results);
				} else {
					displayUsageMessage();
				}
			} else {
				displayUsageMessage();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void displayUsageMessage() {
		System.out.println(" Usage :sti-security.bat <encrypt/decrypt> <orginal/encrypt password>");
		System.out.println(" Example :To encrypt a Password:");
		System.out.println(" c:\\<TOMCAT_HOME\\bin\\sti-security.bat encrypt password");
		System.out.println(" Example :To decrypt a Password, inlcude decrypted password inside double quotes on both ends :");
		System.out.println(" c:\\<TOMCAT_HOME\\bin\\sti-security.bat decrypt \"njBkbbarm3r=\"");
	}
}
