package kw.comso.dto;

import java.util.ArrayList;

public class TestPaperVO {
	private String testPaperIDNum; // �� �������� ������ȣ
	private ArrayList<Long> testInfo; // ������ ���� ������ ����Ǿ� ����, ��� ������ ����Ǿ� �ִ��� ���� ����
	private String html;
	
	// setter
	public void setTestPaperIDNum(String testPaperIDNum) {
		this.testPaperIDNum = testPaperIDNum;
	}
	public void setTestInfo(ArrayList<Long> testInfo) {
		this.testInfo = testInfo;
	}
	public void setHtml(String html) {
		this.html = html;
	}

	// getter
	public String getTestPaperIDNum() {
		return this.testPaperIDNum;
	}
	public ArrayList<Long> getTestInfo() {
		return this.testInfo;
	}
	public String getHtml() {
		return this.html;
	}

}