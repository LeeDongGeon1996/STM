package kw.comso.dao;

import java.util.ArrayList;
import java.util.Hashtable;

import kw.comso.dto.MemberRelationVO;

public interface MemberRelationDAO {
	boolean insertMemberRelation(MemberRelationVO memberRelation);

	boolean updateMemberRelation(MemberRelationVO memberRelation, Hashtable<String, Object> updatedVal);

	boolean removeMemberRelation(MemberRelationVO memberRelation);

	MemberRelationVO findOne(String key, Object value, String[] fields);

	ArrayList<MemberRelationVO> findAll(String key, Object value, String[] fields);
}
