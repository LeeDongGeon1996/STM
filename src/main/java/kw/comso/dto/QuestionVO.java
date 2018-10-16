package kw.comso.dto;

public class QuestionVO { // 각 문제 하나하나를 저장하는 공간, 시험지 아님!!!
	private String questionIDNum; // 각 문제의 고유번호
	private int mulORSub;
	// 이 문제가 객관식인지 주관식인지 선택하는 곳 (0, 1)로 구분하기? 추후에 정하자, mul-multiple=객관식,
	// sub-subjective=주관식
	private String passage; // 문제 지문을 저장함
	private String imageLink; // 이미지가 저장되어 있는 링크를 저장
	private String mulChoice; // 객관식 보기를 저장함
	private String answer; // 답 저장
	private String owner; //문제의 소유자  ex)자이스토리문제인경우 '평가원'으로 저장
	
	private String questionImgLink; //프리뷰에서 제작되어 캡쳐된 이미지
	
	
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
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setQuestionImgLink(String questionImgLink) {
		this.questionImgLink=questionImgLink;
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
	public String getOwner() {
		return owner;
	}
	public String getQuestionImgLink() {
		return questionImgLink;
	}
}