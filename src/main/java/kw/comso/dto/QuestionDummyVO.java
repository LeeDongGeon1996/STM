package kw.comso.dto;

public class QuestionDummyVO { // �� ���� �ϳ��ϳ��� �����ϴ� ����, ������ �ƴ�!!!
	private String questionIDNum; // �� ������ ������ȣ
	private int mulORSub;
	// �� ������ ���������� �ְ������� �����ϴ� �� (0, 1)�� �����ϱ�? ���Ŀ� ������, mul-multiple=������,
	// sub-subjective=�ְ���
	private String passage; // ���� ������ ������
	private String imageLink; // �̹����� ����Ǿ� �ִ� ��ũ�� ����
	private String mulChoice; // ������ ���⸦ ������
	private String answer; // �� ����
	private String owner; //������ ������  ex)���̽��丮�����ΰ�� '�򰡿�'���� ����
	
	
	// setter
	public void setQuestionIDNum(String questionIDNum) {
		this.questionIDNum = questionIDNum;
	}
	public void setMulORSub(int mulORSub) {
		this.mulORSub = mulORSub;
	}
	public void setPassage(String passage) {
		this.passage = passage;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public void setMulChoice(String mulChoice) {
		this.mulChoice = mulChoice;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	// getter
	public String getQuestionIDNum() {
		return this.questionIDNum;
	}
	public int getMulORSub() {
		return this.mulORSub;
	}
	public String getPassage() {
		return this.passage;
	}
	public String getImageLink() {
		return this.imageLink;
	}
	public String getMulChoice() {
		return this.mulChoice;
	}
	public String getAnswer() {
		return this.answer;
	}
}