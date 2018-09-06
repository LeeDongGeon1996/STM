package kw.comso.dao;

import java.util.ArrayList;
import java.util.Hashtable;

import kw.comso.dto.MemberInfoVO;

public interface MemberInfoDAO {
	boolean insertMemberInfo(MemberInfoVO memberInfo);

	boolean updateMemberInfo(MemberInfoVO memberInfo, Hashtable<String, Object> updatedVal);

	boolean removeMemberInfo(MemberInfoVO memberInfo);

	MemberInfoVO findOne(String key, Object value);

	MemberInfoVO findOne(String key, Object value, String[] fields);

	ArrayList<MemberInfoVO> findAll(String key, Object value);
	
	ArrayList<MemberInfoVO> findAll(String key, Object value, String[] fields);
}
