package noobchain;

import java.util.Date;

public class Block {
	public String hash;
	public String previousHash;
	private String data;
	private long timestamp;
	private int nonce;
	
	public Block(String data, String previousHash) {
		super();
		this.previousHash = previousHash;
		this.data = data;
		this.timestamp = new Date().getTime();
		this.hash = this.culculateHash();
	}
	
	public String culculateHash(){
		String culculateHash = StringUtil.applySHA256(
				previousHash +
				Long.toString(timestamp) +
				Integer.toString(nonce) +
				data
				);
		return culculateHash;	
	}
	
	public void mineBlock(int difficulty) {
		
		/** CREATE A STRING WITH DIFFICULTY * "0" **/
		String target = new String(new char[difficulty]).replace('\0', '0');
		
		while(!hash.substring(0, difficulty).equals(target)) {
			nonce++;
			hash = culculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
	}
}
