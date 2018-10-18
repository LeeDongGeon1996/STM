package kw.comso.dto;

public class QuestionVO { // �� ���� �ϳ��ϳ��� �����ϴ� ����, ������ �ƴ�!!!
	private String questionIDNum; // �� ������ ������ȣ
	private int mulORSub;
	// �� ������ ���������� �ְ������� �����ϴ� �� (0, 1)�� �����ϱ�? ���Ŀ� ������, mul-multiple=������,
	// sub-subjective=�ְ���
	private String passage; // ���� ������ ������
	private String imageLink; // �̹����� ����Ǿ� �ִ� ��ũ�� ����
	private String capimageLink;
	private String mulChoice_one; 
	private String mulChoice_two;
	private String mulChoice_three;
	private String mulChoice_four;
	private String mulChoice_five;
	private String answer; // �� ����
	private String owner; //������ ������  ex)���̽��丮�����ΰ�� '�򰡿�'���� ����
	
	private String questionImgLink; //�����信�� ���۵Ǿ� ĸ�ĵ� �̹���
	
	
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
	public void setCapImageLink(String capimageLink) {
		this.capimageLink = capimageLink;
	}
	public void setMulChoiceOne(String mulChoice_one) {
		this.mulChoice_one = mulChoice_one;
	}
	public void setMulChoiceTwo(String mulChoice_two) {
		this.mulChoice_two = mulChoice_two;
	}
	public void setMulChoiceThree(String mulChoice_three) {
		this.mulChoice_three = mulChoice_three;
	}
	public void setMulChoiceFour(String mulChoice_four) {
		this.mulChoice_four = mulChoice_four;
	}
	public void setMulChoiceFive(String mulChoice_five) {
		this.mulChoice_five = mulChoice_five;
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
	public String getCapImageLink() {
		return this.capimageLink;
	}
	public String getMulChoiceOne() {
		return this.mulChoice_one;
	}
	public String getMulChoiceTwo() {
		return this.mulChoice_two;
	}
	public String getMulChoiceThree() {
		return this.mulChoice_three;
	}
	public String getMulChoiceFour() {
		return this.mulChoice_four;
	}
	public String getMulChoiceFive() {
		return this.mulChoice_five;
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