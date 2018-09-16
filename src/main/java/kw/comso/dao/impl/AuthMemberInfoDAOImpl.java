package kw.comso.dao.impl;

import java.util.Hashtable;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import kw.comso.dao.AuthMemberInfoDAO;
import kw.comso.dto.AuthMemberInfoVO;
import kw.comso.dto.MemberInfoVO;

public class AuthMemberInfoDAOImpl implements AuthMemberInfoDAO {

	private MongoTemplate mongoTemplate;
	private static final String TABLE_NAME = "AuthMemberInfo";

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public boolean insertMemberInfo(AuthMemberInfoVO authMemberInfo) {
		this.mongoTemplate.insert(authMemberInfo, TABLE_NAME);

		return true;
	}

	@Override
	public boolean updateMemberInfo(AuthMemberInfoVO authMemberInfo, Hashtable<String, Object> updatedVal) {

		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(authMemberInfo.getEmail()));

		Update update = new Update();

		for (String key : updatedVal.keySet()) {
			update.set(key, updatedVal.get(key));
		}

		mongoTemplate.updateFirst(query, update, TABLE_NAME);

		return true;
	}

	@Override
	public boolean removeMemberInfo(AuthMemberInfoVO authMemberInfo) {
		this.mongoTemplate.remove(authMemberInfo, TABLE_NAME);

		return true;
	}
	
	@Override
	public AuthMemberInfoVO findOne(String key, Object value, String[] fields) {

		Query query = new Query();
		query.addCriteria(Criteria.where(key).is(value));
		if (fields != null) {
			for (String field : fields)
				query.fields().include(field);
		}

		AuthMemberInfoVO found = this.mongoTemplate.findOne(query, AuthMemberInfoVO.class, TABLE_NAME);
		
		return found;
	}

	@Override
	public AuthMemberInfoVO findOne(String key, Object value) {
		return findOne(key, value, null);
	}
}
