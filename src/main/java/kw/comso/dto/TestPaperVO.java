package kw.comso.dto;

import java.util.ArrayList;

public class TestPaperVO {
	private Long testPaperIDNum; // 각 시험지의 고유번호
	private ArrayList<Long> testInfo; // 시험지 문제 정보가 저장되어 있음, 몇번 문제가 저장되어 있는지 정보 저장

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