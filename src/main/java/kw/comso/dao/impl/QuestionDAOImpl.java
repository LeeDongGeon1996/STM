package kw.comso.dao.impl;

import java.util.ArrayList;
import java.util.Hashtable;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import kw.comso.dao.QuestionDAO;
import kw.comso.dto.QuestionVO;
import kw.comso.dto.QuestionVO;

public class QuestionDAOImpl implements QuestionDAO {

	private MongoTemplate mongoTemplate;
	private static final String TABLE_NAME = "Question";

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public boolean insertQuestion(QuestionVO question) {

		this.mongoTemplate.insert(question, TABLE_NAME);

		return true;

	}

	@Override
	public boolean updateQuestion(QuestionVO question, Hashtable<String, Object> updatedVal) {
		Query query = new Query();
		query.addCriteria(Criteria.where("questionIDNum").is(question.getQuestionIDNum()));

		Update update = new Update();
		for (String key : updatedVal.keySet()) {
			update.set(key, updatedVal.get(key));
		}

		mongoTemplate.updateFirst(query, update, TABLE_NAME);

		return true;
	}

	@Override
	public boolean removeQuestion(QuestionVO question) {
		this.mongoTemplate.remove(question, TABLE_NAME);

		return true;
	}

	@Override
	public QuestionVO findOne(String key, Object value, String[] fields) {
		Query query = new Query();
		query.addCriteria(Criteria.where(key).is(value));
		if (fields != null) {
			for (String field : fields)
				query.fields().include(field);
		}

		QuestionVO found = this.mongoTemplate.findOne(query, QuestionVO.class, TABLE_NAME);

		return found;
	}

	@Override
	public QuestionVO findOne(String key, Object value) {
		return findOne(key, value, null);
	}

	@Override
	public ArrayList<QuestionVO> findAll(String key, Object value, String[] fields) {
		Query query = new Query();
		query.addCriteria(Criteria.where(key).is(value));
		if (fields != null) {
			for (String field : fields)
				query.fields().include(field);
		}

		ArrayList<QuestionVO> found = (ArrayList<QuestionVO>) this.mongoTemplate.find(query, QuestionVO.class,
				TABLE_NAME);

		return found;
	}

	@Override
	public ArrayList<QuestionVO> findAll(String key, Object value) {
		return findAll(key, value, null);
	}

	public ArrayList<QuestionVO> findAll() {
		ArrayList<QuestionVO> found = (ArrayList<QuestionVO>) this.mongoTemplate.findAll(QuestionVO.class, TABLE_NAME);

		return found;
	}
	
	public ArrayList<QuestionVO> findWithRegex(String key, String regex){
		
		Query query = new Query();
		query.addCriteria(Criteria.where(key).regex(regex));
		
		ArrayList<QuestionVO> found = (ArrayList<QuestionVO>) this.mongoTemplate.find(query, QuestionVO.class, TABLE_NAME);
	
		return found;
	}

}
