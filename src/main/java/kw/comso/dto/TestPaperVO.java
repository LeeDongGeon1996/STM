package kw.comso.dto;

import java.util.ArrayList;

public class TestPaperVO {
	private int testPaperIDNum; // �� �������� ������ȣ
	private ArrayList testInfo; // ������ ���� ������ ����Ǿ� ����, ��� ������ ����Ǿ� �ִ��� ���� ����

	// setter
	public void setTestPaperIDNum(int testPaperIDNum) {
		this.testPaperIDNum = testPaperIDNum;
	}
	public void setTestPaperIDNum(ArrayList testInfo) {
		this.testInfo = testInfo;
	}

	// getter
	public int getTestPaperIDNum() {
		return this.testPaperIDNum;
	}
	public ArrayList getTestInfo() {
		return this.testInfo;
	}

}