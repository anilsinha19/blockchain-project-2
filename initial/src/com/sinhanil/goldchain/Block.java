package com.sinhanil.goldchain;

import java.util.Date;

public class Block {

	public String hash;
	public String previousHash; 
	private String data; //lets keep a sample text as data for poc.
	private long timeStamp; 
	private int nonce;
	
	//Block Constructor.  
	public Block(String data,String previousHash ) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();		
		this.hash = calculateHash();
	}
	
		//Calculate hash based on all imp parts of block
		public String calculateHash() {
			String calculatedhash = DigitalSignatureUtil.applySha256( 
					previousHash +
					Long.toString(timeStamp) +
					Integer.toString(nonce) + 
					data 
					);
			return calculatedhash;
		}
					
		//Increases nonce value until hash target is reached.
		public void mineBlock(int difficultyLevel) {
			String target = StringUtil.getDificultyString(difficultyLevel); //Create a string with difficulty * "0" 
			while(!hash.substring( 0, difficultyLevel).equals(target)) {
				nonce ++;
				hash = calculateHash();
			}
			System.out.println("Block Mined!!! : " + hash);
		}
}
