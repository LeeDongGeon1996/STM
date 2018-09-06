package kw.comso.dao;

import java.util.ArrayList;
import java.util.Hashtable;

import kw.comso.dto.QuestionVO;

public interface QuestionDAO {
	boolean insertQuestion(QuestionVO question);

	boolean updateQuestion(QuestionVO question, Hashtable<String, Object> updatedVal);

	boolean removeQuestion(QuestionVO question);

	QuestionVO findOne(String key, Object value);
	
	QuestionVO findOne(String key, Object value, String[] fields);
	
	ArrayList<QuestionVO> findAll();
	
	ArrayList<QuestionVO> findAll(String key, Object value);

	ArrayList<QuestionVO> findAll(String key, Object value, String[] fields);
	
	ArrayList<QuestionVO> findWithRegex(String key, String regex);
}
