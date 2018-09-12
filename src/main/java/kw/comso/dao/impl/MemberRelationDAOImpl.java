package kw.comso.dao.impl;

import java.util.ArrayList;
import java.util.Hashtable;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import kw.comso.dao.MemberRelationDAO;
import kw.comso.dto.MemberRelationVO;

public class MemberRelationDAOImpl implements MemberRelationDAO {

	private MongoTemplate mongoTemplate;
	private static final String TABLE_NAME = "MemberRelation";

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public boolean insertMemberRelation(MemberRelationVO memberRelation) {

		mongoTemplate.insert(memberRelation, TABLE_NAME);

		return true;
	}

	@Override
	public boolean updateMemberRelation(MemberRelationVO memberRelation, Hashtable<String, Object> updatedVal) {

		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(memberRelation.getEmail()));

		Update update = new Update();
		for (String key : updatedVal.keySet()) {
			update.set(key, updatedVal.get(key));
		}

		mongoTemplate.updateFirst(query, update, TABLE_NAME);

		return true;
	}

	@Override
	public boolean removeMemberRelation(MemberRelationVO memberRelation) {

		mongoTemplate.remove(memberRelation, TABLE_NAME);

		return true;
	}

	@Override
	public MemberRelationVO findOne(String key, Object value, String[] fields) {
		Query query = new Query();
		query.addCriteria(Criteria.where(key).is(value));
		if (fields != null) {
			for (String field : fields)
				query.fields().include(field);
		}

		MemberRelationVO found = this.mongoTemplate.findOne(query, MemberRelationVO.class, TABLE_NAME);

		return found;
	}

	public MemberRelationVO findOne(String key, Object value) {
		return findOne(key, value, null);
	}

	@Override
	public ArrayList<MemberRelationVO> findAll(String key, Object value, String[] fields) {
		Query query = new Query();
		query.addCriteria(Criteria.where(key).is(value));
		if (fields != null) {
			for (String field : fields)
				query.fields().include(field);
		}

		ArrayList<MemberRelationVO> found = (ArrayList<MemberRelationVO>) this.mongoTemplate.find(query,
				MemberRelationVO.class, TABLE_NAME);

		return found;
	}

	public ArrayList<MemberRelationVO> findAll(String key, Object value) {
		return findAll(key, value, null);
	}

}
