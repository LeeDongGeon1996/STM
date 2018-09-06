package kw.comso.service.impl;

import java.util.ArrayList;

import kw.comso.dao.QuestionDAO;
import kw.comso.dao.TestPaperDAO;
import kw.comso.dao.impl.QuestionDAOImpl;
import kw.comso.dto.QuestionVO;
import kw.comso.dto.TestPaperVO;
import kw.comso.service.QuestionService;
import kw.comso.util.Util;

public class QuestionServiceImpl implements QuestionService {

	private QuestionDAO questionDAO;
	private TestPaperDAO testPaperDAO;

	public void setQuestionDAO(QuestionDAOImpl questionDAO) {
		this.questionDAO = questionDAO;
	}

	public void setTestPaperDAO(TestPaperDAO testPaperDAO) {
		this.testPaperDAO = testPaperDAO;
	}

	@Override
	public QuestionVO getQuestion(int questionID) {

		QuestionVO target = this.questionDAO.findOne("questionIDNum", questionID);

		if (target == null)
			return null;

		return target;
	}

	@Override
	public ArrayList<QuestionVO> getQuestion(String memberID) {
		
		String regex = "^" + memberID.hashCode();
		ArrayList<QuestionVO> questionList = this.questionDAO.findWithRegex("questionIDNum", regex);
		
		return questionList;
	}

	@Override
	public ArrayList<QuestionVO> getTestPaper(int testPaperID) {

		TestPaperVO targetTestPaper = this.testPaperDAO.findOne("testPaperIDNum", testPaperID);

		if (targetTestPaper == null)
			return null;

		ArrayList<QuestionVO> questionList = targetTestPaper.getTestInfo();
		return questionList;
	}

	@Override
	public boolean registerQuestion(String memberID, QuestionVO question) {

		question.setQuestionIDNum(Util.createID(memberID));

		// 사용자가 등록하는 문제도 중복처리를 해야하나?
		return this.questionDAO.insertQuestion(question);

	}

	@Override
	public boolean deleteQuestion(int questionID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTestPaper(TestPaperVO testPaper) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerTestPaper(String memberID, TestPaperVO testPaper) {
		// TODO Auto-generated method stub
		return false;
	}
}
