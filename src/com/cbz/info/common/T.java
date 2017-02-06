package com.cbz.info.common;

public class T {
	
	public static boolean isBlank(Object str){
		
		if(str!=null&&!"".equals(str)){
			return false ;
		} else {
			return true;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(T.isBlank("dd"));
	}

}
