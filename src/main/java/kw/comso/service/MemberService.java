package kw.comso.service;

import kw.comso.dto.MemberInfoVO;

public interface MemberService {

	//�ߺ��� ��� false
	boolean registerMember(MemberInfoVO member);
	boolean deleteMember(MemberInfoVO member);
	boolean updateMember(MemberInfoVO member);
}
