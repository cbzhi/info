package com.cbz.info.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class U {

	
	public static String MD5(String str) {
		try {
			MessageDigest ist = MessageDigest.getInstance("MD5");
			ist.update(str.getBytes());
			return new BigInteger(1,ist.digest()).toString(16);
		} catch (NoSuchAlgorithmException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	public static void main(String[] args) {
		String md5 = U.MD5("nihao");
		System.out.println("md5=="+md5);
		String string = new String("0wwd1");
		BigInteger bigInteger = new BigInteger(-1,string.getBytes());
		System.out.println(bigInteger.toString(16));
		String string2 = new BigInteger("1923fad",16).toString(20);
		System.out.println("string2=="+string2);
	}
	
}
