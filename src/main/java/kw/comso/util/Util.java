package kw.comso.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Util {

	private static Gson gson = new GsonBuilder().create();
	
	public static String createID(String value) {
		
		String token = "";
		String code = String.valueOf(value.hashCode()).substring(1);
		String unique = String.valueOf(System.currentTimeMillis()).substring(3);
		
		//System.out.println(unique);
		System.out.println("Unique ID : " + code + token + unique);
		return code + token + unique;
	}
	
	public static void sendRedirect(HttpServletResponse response, String url) {
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String toJson(Object object) {
		return gson.toJson(object);
	}
}
