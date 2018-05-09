package noobchain;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class StringUtil {
	
	public static String applySHA256(String input) {
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			
			/** APPLIES SHA256 TO INPUT STRING **/
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
			
			/** STORES HASH AS HEXADECIMAL **/
			StringBuffer hexString = new StringBuffer();
			
			for(int i = 0; i < hash.length; i++) {			
//				System.out.println("Prefix :: " + 0xff);
//				System.out.println("Hash :: " + hash[i]);
//				System.out.print("Combined :: ");
//				System.out.println( 0xff & hash[i]);	
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			
			return hexString.toString();
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
