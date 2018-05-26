package com.sinhanil.test;

import com.sinhanil.goldchain.DigitalSignatureUtil;

public class Test {

	public static  void main(String[] args) {
		String text = "Blockchain";
		String hashText = DigitalSignatureUtil.applySha256(text);
		System.out.println(text + " : " +hashText);

		text = "blockchain";
		hashText = DigitalSignatureUtil.applySha256(text);
		System.out.println(text + " : " +hashText);
	}
}
