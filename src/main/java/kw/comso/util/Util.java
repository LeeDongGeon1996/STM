package kw.comso.util;

public class Util {

	public static int createID(String value) {
		
		String code = String.valueOf(value.hashCode());
		String unique = String.valueOf(System.currentTimeMillis());
		
		return Integer.parseInt(code + "@" + unique);
	}
}
