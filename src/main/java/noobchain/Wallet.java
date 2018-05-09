package noobchain;

import java.security.*;
import java.security.spec.ECGenParameterSpec;

public class Wallet {
	public PrivateKey privateKey;
	public PublicKey publicKey;
	
	
	public Wallet() {
	
	}
	
	public void generateKeyPair(){
		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA", "BC");
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG"); 
			ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
			
			/** INITIALIZE THE KEY GENERATOR **/
			keyGen.initialize(ecSpec, random); //256 bytes provides an acceptable security level
			
			/** & GENERATE A KETPAIR **/
			KeyPair keyPair = keyGen.generateKeyPair();
			
			// Assign private key from the keyPair
			privateKey = keyPair.getPrivate();
			
			// Assign public key from the keyPair
			publicKey = keyPair.getPublic();
			
		} catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidAlgorithmParameterException e) {
			throw new RuntimeException(e);
		}
		
	}
}
