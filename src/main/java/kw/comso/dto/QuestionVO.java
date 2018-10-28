package kw.comso.dto;

public class QuestionVO { // 占쏙옙 占쏙옙占쏙옙 占싹놂옙占싹놂옙占쏙옙 占쏙옙占쏙옙占싹댐옙 占쏙옙占쏙옙, 占쏙옙占쏙옙占쏙옙 占싣댐옙!!!
	private String questionIDNum; // 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙호
	private int mulORSub;
	// 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쌍곤옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占싹댐옙 占쏙옙 (0, 1)占쏙옙 占쏙옙占쏙옙占싹깍옙? 占쏙옙占식울옙 占쏙옙占쏙옙占쏙옙, mul-multiple=占쏙옙占쏙옙占쏙옙,
	// sub-subjective=占쌍곤옙占쏙옙
	private String passage; // 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
	private String imageLink; // 占싱뱄옙占쏙옙占쏙옙 占쏙옙占쏙옙퓸占� 占쌍댐옙 占쏙옙크占쏙옙 占쏙옙占쏙옙
	private String capimageLink;
	private String mulChoice_one; 
	private String mulChoice_two;
	private String mulChoice_three;
	private String mulChoice_four;
	private String mulChoice_five;
	
	private String answer; // 占쏙옙 占쏙옙占쏙옙
	private String owner; //占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙  ex)占쏙옙占싱쏙옙占썰리占쏙옙占쏙옙占싸곤옙占� '占쏠가울옙'占쏙옙占쏙옙 占쏙옙占쏙옙
	private String capValue;

	
	private String questionImgLink; //占쏙옙占쏙옙占썰에占쏙옙 占쏙옙占쌜되억옙 캡占식듸옙 占싱뱄옙占쏙옙
	
	
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
	public void setCapValue(String capValue) {
		this.capValue=capValue;
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
	public String getCapValue() {
		return capValue;
	}
}