package kw.comso.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import kw.comso.dao.QuestionDAO;
import kw.comso.dao.TestPaperDAO;
import kw.comso.dao.impl.QuestionDAOImpl;
import kw.comso.dto.QuestionVO;
import kw.comso.dto.TestPaperVO;
import kw.comso.service.QuestionService;
import kw.comso.util.Util;

public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDAO questionDAO;
	@Autowired
	private TestPaperDAO testPaperDAO;

	public void setQuestionDAO(QuestionDAOImpl questionDAO) {
		this.questionDAO = questionDAO;
	}

	public void setTestPaperDAO(TestPaperDAO testPaperDAO) {
		this.testPaperDAO = testPaperDAO;
	}

	@Override
	public QuestionVO getQuestion(int questionID) {

		//questionVO의 아이디로 문항을 가져옴, 아직까지 필요없는 메소드..
		QuestionVO target = this.questionDAO.findOne("questionIDNum", questionID);
		if (target == null)
			return null;

		return target;
	}

	@Override
	public ArrayList<QuestionVO> getQuestion(String memberID) {
		
		//해당사용자로 등록된 문항 모두 가져오기.
		String regex = "^" + memberID.hashCode();
		ArrayList<QuestionVO> questionList = this.questionDAO.findWithRegex("questionIDNum", regex);
		
		return questionList;
	}

	@Override
	public ArrayList<QuestionVO> getTestPaper(int testPaperID) {

		//시험지 존재 검사.
		TestPaperVO targetTestPaper = this.testPaperDAO.findOne("testPaperIDNum", testPaperID);
		if (targetTestPaper == null)
			return null;

		//시험지에 포함된 문항가져오기.
		ArrayList<Long> IDList = targetTestPaper.getTestInfo();
		ArrayList<QuestionVO> questionList  = new ArrayList<QuestionVO>();
		for(Long questionID : IDList)
			questionList.add(this.questionDAO.findOne("questionIDNum", questionID));
		
		return questionList;
	}

	@Override
	public boolean registerQuestion(String memberID, QuestionVO question) {

		question.setQuestionIDNum(Util.createID(memberID));

		// 사용자가 등록하는 문제도 중복처리를 해야하나?
		return this.questionDAO.insertQuestion(question);

	}

	@Override
	public boolean registerTestPaper(String memberID, TestPaperVO testPaper) {
		
		testPaper.setTestPaperIDNum(Util.createID(memberID));
		
		//중복처리???
		return this.testPaperDAO.insertTestPaper(testPaper);
	}
	
	@Override
	public boolean deleteQuestion(Long questionID) {
		// 문제가 사라지면 그 문제를 가지고있던 시험지 객체도 리스트를 업데이트해야 함.
		return this.questionDAO.removeQuestion(
				this.questionDAO.findOne("questionIDNum", questionID));
	}

	@Override
	public boolean deleteTestPaper(Long testPaperID) {
		return this.testPaperDAO.removeTestPaper(
				this.testPaperDAO.findOne("testPaperIDNum", testPaperID));
	}
}
