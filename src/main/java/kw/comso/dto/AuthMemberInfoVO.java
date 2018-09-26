package kw.comso.dto;

public class AuthMemberInfoVO {
	private String email;
	private String userName;
	private String auth;

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return this.email;
	}

	public String getAuth() {
		return this.auth;
	}

	public String getUserName() {
		return this.userName;
	}
}
