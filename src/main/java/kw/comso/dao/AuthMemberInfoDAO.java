package kw.comso.dao;

import java.util.Hashtable;

import kw.comso.dto.AuthMemberInfoVO;
import kw.comso.dto.MemberInfoVO;

public interface AuthMemberInfoDAO {
	boolean insertMemberInfo(AuthMemberInfoVO authMemberInfo);

	boolean updateMemberInfo(AuthMemberInfoVO authMemberInfo, Hashtable<String, Object> updatedVal);

	boolean removeMemberInfo(AuthMemberInfoVO authMemberInfo);

	AuthMemberInfoVO findOne(String key, Object value, String[] fields);
	
	AuthMemberInfoVO findOne(String key, Object value);
}
