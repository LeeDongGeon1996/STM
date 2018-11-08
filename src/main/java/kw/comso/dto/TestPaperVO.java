package kw.comso.dto;

import java.util.ArrayList;

public class TestPaperVO {
	private String testPaperIDNum; // �� �������� ������ȣ
	private ArrayList<Long> testInfo; // ������ ���� ������ ����Ǿ� ����, ��� ������ ����Ǿ� �ִ��� ���� ����
	private String captestLink;
	private String captestValue;
	private String html;
	private String htmlLink;

	// setter
	public void setTestPaperIDNum(String testPaperIDNum) {
		this.testPaperIDNum = testPaperIDNum;
	}

	public void setTestInfo(ArrayList<Long> testInfo) {
		this.testInfo = testInfo;
	}

	public void setCapTestLink(String captestLink) {
		this.captestLink = captestLink;
	}

	public void setCapTestValue(String captestValue) {
		this.captestValue = captestValue;
	}

	public void setHtml(String html) {
		this.html = html;
	}
	public void setHtmlLink(String htmlLink) {
		this.htmlLink = htmlLink;
	}

	// getter
	public String getTestPaperIDNum() {
		return this.testPaperIDNum;
	}

	public ArrayList<Long> getTestInfo() {
		return this.testInfo;
	}

	public String getCapTestLink() {
		return this.captestLink;
	}

	public String getCapTestValue() {
		return this.captestValue;
	}

	public String getHtml() {
		return this.html;
	}

	public String getHtmlLink() {
		return this.htmlLink;
	}

}