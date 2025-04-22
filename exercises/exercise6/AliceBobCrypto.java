package exercise6;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class AliceBobCrypto {
    public static void main(String[] args) throws Exception{
        // generate symmetric key for AES-256
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey key = keyGen.generateKey();

        // generate RSA key pairs for Alice and Bob
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair aliceKeyPair = keyPairGen.generateKeyPair();
        KeyPair bobKeyPair = keyPairGen.generateKeyPair();

        // Message to be sent
        String message = "Hello Bob, this is Alice!";

        // Symmetric encryption (AES-256-GCM)
        System.out.println("\n=== Symmetric Encryption (AES-256-GCM) ===");
        byte[] iv = new byte[12]; // initialization vector
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        GCMParameterSpec spec = new GCMParameterSpec(128, iv);

        // Alice encrypts the message
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key, spec);
        byte[] encryptedMessage = cipher.doFinal(message.getBytes());
        System.out.println("Alice encrypted message: " + Base64.getEncoder().encodeToString(encryptedMessage));

        // Bob decrypts the message
        cipher.init(Cipher.DECRYPT_MODE, key, spec);
        byte[] decryptedMessage = cipher.doFinal(encryptedMessage);
        System.out.println("Bob decrypted message: " + new String(decryptedMessage));

        // Asymmetric encryption (RSA-2048)
        System.out.println("\n=== Asymmetric Encryption (RSA-2048) ===");
        // Alice encrypts the message
        Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        rsaCipher.init(Cipher.ENCRYPT_MODE, bobKeyPair.getPublic());
        byte[] rsaEncrypted = rsaCipher.doFinal(message.getBytes());
        System.out.println("RSA Encrypted: " + Base64.getEncoder().encodeToString(rsaEncrypted));

        // Bob decrypts the message
        rsaCipher.init(Cipher.DECRYPT_MODE, bobKeyPair.getPrivate());
        byte[] rsaDecrypted = rsaCipher.doFinal(rsaEncrypted);
        System.out.println("RSA Decrypted: " + new String(rsaDecrypted));

        // Message Signing and Verification
        System.out.println("\n=== Message Signing and Verification ===");
        // Alice signs the message with her private key
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(aliceKeyPair.getPrivate());
        signature.update(message.getBytes());
        byte[] digitalSignature = signature.sign(); // digital signature
        System.out.println("Signature: " + Base64.getEncoder().encodeToString(digitalSignature));

        // Bob verifies the signature with Alice's public key
        signature.initVerify(aliceKeyPair.getPublic());
        signature.update(message.getBytes());
        boolean isValid = signature.verify(digitalSignature); // true or false
        System.out.println("Signature valid: " + isValid);

    }
}
