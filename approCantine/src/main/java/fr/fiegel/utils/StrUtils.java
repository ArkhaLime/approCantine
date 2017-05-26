package fr.fiegel.utils;

public class StrUtils {

	public static boolean isNullOrEmpty(String str){
		if(str == null) return true;
		if(str.trim().equals("")) return true;
		return false;
	}

}
