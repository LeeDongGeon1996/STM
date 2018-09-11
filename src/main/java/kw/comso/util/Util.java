package kw.comso.util;

public class Util {

	public static Long createID(String value) {
		
		String code = String.valueOf(value.hashCode());
		String unique = String.valueOf(System.currentTimeMillis());
		
		//System.out.println(Integer.parseInt(code + "@" + unique));
		return Long.parseLong(code + "@" + unique);
	}
}
