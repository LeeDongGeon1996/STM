package kw.comso.dao;

import java.util.ArrayList;
import java.util.Hashtable;

import kw.comso.dto.QuestionDummyVO;

public interface QuestionDummyDAO {
	boolean insertQuestion(QuestionDummyVO question);

	boolean updateQuestion(QuestionDummyVO question, Hashtable<String, Object> updatedVal);

	boolean removeQuestion(QuestionDummyVO question);

	QuestionDummyVO findOne(String key, Object value);
	
	QuestionDummyVO findOne(String key, Object value, String[] fields);
	
	ArrayList<QuestionDummyVO> findAll();
	
	ArrayList<QuestionDummyVO> findAll(String key, Object value);

	ArrayList<QuestionDummyVO> findAll(String key, Object value, String[] fields);
	
	ArrayList<QuestionDummyVO> findWithRegex(String key, String regex);
}
