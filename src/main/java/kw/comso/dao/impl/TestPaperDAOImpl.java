package kw.comso.dao.impl;

import java.util.ArrayList;
import java.util.Hashtable;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import kw.comso.dao.TestPaperDAO;
import kw.comso.dto.QuestionVO;
import kw.comso.dto.TestPaperVO;

public class TestPaperDAOImpl implements TestPaperDAO {

	private MongoTemplate mongoTemplate;
	private static final String TABLE_NAME = "TestPaper";

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public boolean insertTestPaper(TestPaperVO testPaper) {

		this.mongoTemplate.insert(testPaper, TABLE_NAME);

		return true;

	}

	@Override
	public boolean updateTestPaper(TestPaperVO testPaper, Hashtable<String, Object> updatedVal) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(testPaper.getTestPaperIDNum()));

		Update update = new Update();
		for (String key : updatedVal.keySet()) {
			update.set(key, updatedVal.get(key));
		}

		mongoTemplate.updateFirst(query, update, TABLE_NAME);

		return true;
	}

	@Override
	public boolean removeTestPaper(TestPaperVO testPaper) {
		this.mongoTemplate.remove(testPaper);

		return true;
	}

	@Override
	public TestPaperVO findOne(String key, Object value, String[] fields) {
		Query query = new Query();
		query.addCriteria(Criteria.where(key).is(value));
		if (fields != null) {
			for (String field : fields)
				query.fields().include(field);
		}

		TestPaperVO found = this.mongoTemplate.findOne(query, TestPaperVO.class, TABLE_NAME);

		return found;
	}

	public TestPaperVO findOne(String key, Object value) {
		return findOne(key, value, null);
	}

	@Override
	public ArrayList<TestPaperVO> findAll(String key, Object value, String[] fields) {
		Query query = new Query();
		query.addCriteria(Criteria.where(key).is(value));
		if (fields != null) {
			for (String field : fields)
				query.fields().include(field);
		}

		ArrayList<TestPaperVO> found = (ArrayList<TestPaperVO>) this.mongoTemplate.find(query, TestPaperVO.class,
				TABLE_NAME);

		return found;
	}

	public ArrayList<TestPaperVO> findAll(String key, Object value) {
		return findAll(key, value, null);
	}

	public ArrayList<TestPaperVO> findAll() {
		ArrayList<TestPaperVO> found = (ArrayList<TestPaperVO>) this.mongoTemplate.findAll(TestPaperVO.class,
				TABLE_NAME);

		return found;
	}

	@Override
	public ArrayList<TestPaperVO> findWithRegex(String key, String regex) {

		Query query = new Query();
		query.addCriteria(Criteria.where(key).regex(regex));
		System.out.println(regex);
		
		//만약 결과가 없어도 비어있는 리스트를 반환한다!!!!!!
		ArrayList<TestPaperVO> found = (ArrayList<TestPaperVO>) this.mongoTemplate.find(query, TestPaperVO.class,
				TABLE_NAME);

		return found;
	}

}
