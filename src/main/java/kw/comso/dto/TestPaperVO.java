package kw.comso.dto;

import java.util.ArrayList;

public class TestPaperVO {
	private Long testPaperIDNum; // �� �������� ������ȣ
	private ArrayList<Long> testInfo; // ������ ���� ������ ����Ǿ� ����, ��� ������ ����Ǿ� �ִ��� ���� ����

	// setter
	public void setTestPaperIDNum(Long testPaperIDNum) {
		this.testPaperIDNum = testPaperIDNum;
	}
	public void setTestInfo(ArrayList<Long> testInfo) {
		this.testInfo = testInfo;
	}

	// getter
	public Long getTestPaperIDNum() {
		return this.testPaperIDNum;
	}
	public ArrayList<Long> getTestInfo() {
		return this.testInfo;
	}

}