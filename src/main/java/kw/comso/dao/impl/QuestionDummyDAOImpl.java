package kw.comso.dao.impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.regex.Pattern;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import kw.comso.dao.QuestionDummyDAO;
import kw.comso.dto.QuestionDummyVO;

public class QuestionDummyDAOImpl implements QuestionDummyDAO {

	private MongoTemplate mongoTemplate;
	private static final String TABLE_NAME = "QuestionDummy";

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public boolean insertQuestion(QuestionDummyVO question) {

		this.mongoTemplate.insert(question, TABLE_NAME);

		return true;

	}

	@Override
	public boolean updateQuestion(QuestionDummyVO question, Hashtable<String, Object> updatedVal) {
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
	public boolean removeQuestion(QuestionDummyVO question) {
		this.mongoTemplate.remove(question);

		return true;
	}

	@Override
	public QuestionDummyVO findOne(String key, Object value, String[] fields) {
		Query query = new Query();
		query.addCriteria(Criteria.where(key).is(value));
		if (fields != null) {
			for (String field : fields)
				query.fields().include(field);
		}

		QuestionDummyVO found = this.mongoTemplate.findOne(query, QuestionDummyVO.class, TABLE_NAME);

		return found;
	}

	@Override
	public QuestionDummyVO findOne(String key, Object value) {
		return findOne(key, value, null);
	}

	@Override
	public ArrayList<QuestionDummyVO> findAll(String key, Object value, String[] fields) {
		Query query = new Query();
		query.addCriteria(Criteria.where(key).is(value));
		if (fields != null) {
			for (String field : fields)
				query.fields().include(field);
		}

		ArrayList<QuestionDummyVO> found = (ArrayList<QuestionDummyVO>) this.mongoTemplate.find(query, QuestionDummyVO.class,
				TABLE_NAME);

		return found;
	}

	@Override
	public ArrayList<QuestionDummyVO> findAll(String key, Object value) {
		return findAll(key, value, null);
	}

	public ArrayList<QuestionDummyVO> findAll() {
		ArrayList<QuestionDummyVO> found = (ArrayList<QuestionDummyVO>) this.mongoTemplate.findAll(QuestionDummyVO.class, TABLE_NAME);

		return found;
	}

	public ArrayList<QuestionDummyVO> findWithRegex(String key, String regex) {

		Query query = new Query();
		query.addCriteria(Criteria.where(key).regex(regex));
		System.out.println(regex);
		
		//만약 결과가 없어도 비어있는 리스트를 반환한다!!!!!!
		ArrayList<QuestionDummyVO> found = (ArrayList<QuestionDummyVO>) this.mongoTemplate.find(query, QuestionDummyVO.class,
				TABLE_NAME);

		return found;
	}

}
