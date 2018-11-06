package kw.comso.dto;

import java.util.ArrayList;

public class TestPaperVO {
	private Long testPaperIDNum; // �� �������� ������ȣ
	private ArrayList<Long> testInfo; // ������ ���� ������ ����Ǿ� ����, ��� ������ ����Ǿ� �ִ��� ���� ����
	private String captestLink;
	private String captestValue;
	// setter
	public void setTestPaperIDNum(Long testPaperIDNum) {
		this.testPaperIDNum = testPaperIDNum;
	}
	public void setTestInfo(ArrayList<Long> testInfo) {
		this.testInfo = testInfo;
	}
	
	public void setCapTestLink(String captestLink) {
		this.captestLink=captestLink;
	}
	public void setCapTestValue(String captestValue) {
		this.captestValue=captestValue;
	}

	// getter
	public Long getTestPaperIDNum() {
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

}