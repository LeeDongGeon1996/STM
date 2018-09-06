package kw.comso.service;

import kw.comso.dto.MemberInfoVO;

public interface MemberService {

	//중복될 경우 false
	boolean registerMember(MemberInfoVO member);
	boolean deleteMember(MemberInfoVO member);
	boolean updateMember(MemberInfoVO member);
}
