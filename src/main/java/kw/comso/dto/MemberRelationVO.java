package kw.comso.dto;

import java.util.ArrayList;

public class MemberRelationVO {

	private String email;
	private String myTeacher;
	private ArrayList<String> myStudent;

	// setter
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMyTeacher(String myTeacher) {
		this.myTeacher = myTeacher;
	}
	public void setMyStudent(ArrayList<String> myStudent) {
		this.myStudent = myStudent;
	}

	// getter
	public String getEmail() {
		return this.email;
	}
	public String getMyTeacher() {
		return this.myTeacher;
	}
	public ArrayList<String> getMyStudent() {
		return this.myStudent;
	}
}
