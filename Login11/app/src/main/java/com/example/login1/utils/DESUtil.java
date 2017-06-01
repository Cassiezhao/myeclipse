package com.example.login1.utils;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;


public class DESUtil {
	/**
	 * public static void main(String[] args) {
		// TODO Auto-generated method stub
		String message = "hello world!";
		String password = "1234567812345678";
		
		byte[] desEncode = jdkDESENcode(message, password);
		System.out.println("DES加密后："+convertByteToHexString(desEncode));
		
		byte[] desDecode = jdkDESDEcode(desEncode, password);
		System.out.println("DES解密后："+new String(desDecode));
	}
	 * 
	 */
	
	/**
	 * 将byte数组传化为16进制数
	 * 
	 * @param bytes
	 * @return
	 * 
	 */
	
	public static String convertByteToHexString(byte[] bytes) {
		String result = "";
		for(int i = 0;i < bytes.length;i++) {
			int temp = bytes[i]&0xff;
			String tempHex = Integer.toHexString(temp);
			if(tempHex.length()<2){
				result += "0"+ tempHex;
			}else {
				result +=tempHex;
			}	
		}
		return result;
	}
	
	/**
	 * jdk des加密
	 * @param message
	 * @param password
	 * @return
	 */
	public static byte[] jdkDESENcode(String message,String password){
		try{
			SecureRandom random = new SecureRandom();
			DESKeySpec keySpec = new DESKeySpec(password.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey secretKey = keyFactory.generateSecret(keySpec);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey,random);
			byte[] result = cipher.doFinal(message.getBytes());
			return result;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * jdk des解密
	 * @param message
	 * @param password
	 * @return
	 */
	public static byte[] jdkDESDEcode(byte[] message,String password){
		try{
			SecureRandom random = new SecureRandom();
			DESKeySpec keySpec = new DESKeySpec(password.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey secretKey = keyFactory.generateSecret(keySpec);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey,random);
			byte[] result = cipher.doFinal(message);
			return result;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}