package kw.comso.dto;

import java.util.ArrayList;

public class TestPaperVO {
	private int testPaperIDNum; // 각 시험지의 고유번호
	private ArrayList testInfo; // 시험지 문제 정보가 저장되어 있음, 몇번 문제가 저장되어 있는지 정보 저장

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