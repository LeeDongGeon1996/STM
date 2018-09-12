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

		//questionVO�� ���̵�� ������ ������, �������� �ʿ���� �޼ҵ�..
		QuestionVO target = this.questionDAO.findOne("questionIDNum", questionID);
		if (target == null)
			return null;

		return target;
	}

	@Override
	public ArrayList<QuestionVO> getQuestion(String memberID) {
		
		//�ش����ڷ� ��ϵ� ���� ��� ��������.
		String regex = "^" + memberID.hashCode();
		ArrayList<QuestionVO> questionList = this.questionDAO.findWithRegex("questionIDNum", regex);
		
		return questionList;
	}

	@Override
	public ArrayList<QuestionVO> getTestPaper(int testPaperID) {

		//������ ���� �˻�.
		TestPaperVO targetTestPaper = this.testPaperDAO.findOne("testPaperIDNum", testPaperID);
		if (targetTestPaper == null)
			return null;

		//�������� ���Ե� ���װ�������.
		ArrayList<Long> IDList = targetTestPaper.getTestInfo();
		ArrayList<QuestionVO> questionList  = new ArrayList<QuestionVO>();
		for(Long questionID : IDList)
			questionList.add(this.questionDAO.findOne("questionIDNum", questionID));
		
		return questionList;
	}

	@Override
	public boolean registerQuestion(String memberID, QuestionVO question) {

		question.setQuestionIDNum(Util.createID(memberID));

		// ����ڰ� ����ϴ� ������ �ߺ�ó���� �ؾ��ϳ�?
		return this.questionDAO.insertQuestion(question);

	}

	@Override
	public boolean registerTestPaper(String memberID, TestPaperVO testPaper) {
		
		testPaper.setTestPaperIDNum(Util.createID(memberID));
		
		//�ߺ�ó��???
		return this.testPaperDAO.insertTestPaper(testPaper);
	}
	
	@Override
	public boolean deleteQuestion(Long questionID) {
		// ������ ������� �� ������ �������ִ� ������ ��ü�� ����Ʈ�� ������Ʈ�ؾ� ��.
		return this.questionDAO.removeQuestion(
				this.questionDAO.findOne("questionIDNum", questionID));
	}

	@Override
	public boolean deleteTestPaper(Long testPaperID) {
		return this.testPaperDAO.removeTestPaper(
				this.testPaperDAO.findOne("testPaperIDNum", testPaperID));
	}
}
