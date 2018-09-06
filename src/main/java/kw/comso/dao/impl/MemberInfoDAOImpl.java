package kw.comso.dao.impl;

import java.util.ArrayList;
import java.util.Hashtable;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import kw.comso.dao.MemberInfoDAO;
import kw.comso.dto.MemberInfoVO;

public class MemberInfoDAOImpl implements MemberInfoDAO {

	private MongoTemplate mongoTemplate;
	private static final String TABLE_NAME = "MemberInfo";

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public boolean insertMemberInfo(MemberInfoVO memberInfo) {

		this.mongoTemplate.insert(memberInfo, TABLE_NAME);

		return true;

	}

	@Override
	public boolean updateMemberInfo(MemberInfoVO memberInfo, Hashtable<String, Object> updatedVal) {

		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(memberInfo.getEmail()));

		Update update = new Update();

		for (String key : updatedVal.keySet()) {
			update.set(key, updatedVal.get(key));
		}

		mongoTemplate.updateFirst(query, update, TABLE_NAME);

		return true;
	}

	@Override
	public boolean removeMemberInfo(MemberInfoVO memberInfo) {
		this.mongoTemplate.remove(memberInfo, TABLE_NAME);

		return true;
	}

	@Override
	public MemberInfoVO findOne(String key, Object value, String[] fields) {

		Query query = new Query();
		query.addCriteria(Criteria.where(key).is(value));
		if (fields != null) {
			for (String field : fields)
				query.fields().include(field);
		}

		MemberInfoVO found = this.mongoTemplate.findOne(query, MemberInfoVO.class, TABLE_NAME);
		
		return found;
	}

	@Override
	public MemberInfoVO findOne(String key, Object value) {
		return findOne(key, value, null);
	}

	@Override
	public ArrayList<MemberInfoVO> findAll(String key, Object value, String[] fields) {
		Query query = new Query();
		query.addCriteria(Criteria.where(key).is(value));
		if (fields != null) {
			for (String field : fields)
				query.fields().include(field);
		}

		ArrayList<MemberInfoVO> found = (ArrayList<MemberInfoVO>) this.mongoTemplate.find(query, MemberInfoVO.class,
				TABLE_NAME);

		return found;
	}

	@Override
	public ArrayList<MemberInfoVO> findAll(String key, Object value) {
		return findAll(key, value, null);
	}

}
