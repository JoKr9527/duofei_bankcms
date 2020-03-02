package cn.joker.utils;

public class CheckInput {
	
	public static boolean check(String...s){
		
		boolean ok = true;
		String regex = "^[A-Za-z0-9]+$";
		for(String ss:s){
			if(ss != null){
				if(! ss.matches(regex))
					ok = false;
			}else
				ok = false;
				
		}
		return ok;
		
	}
}
