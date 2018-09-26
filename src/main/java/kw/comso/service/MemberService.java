package kw.comso.service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kw.comso.dto.AuthMemberInfoVO;
import kw.comso.dto.MemberInfoVO;

public interface MemberService {

	//중복될 경우 false
	boolean registerMember(MemberInfoVO member);
	boolean deleteMember(MemberInfoVO member);
	boolean updateMember(MemberInfoVO member);
	boolean checkPassword(MemberInfoVO member);
	AuthMemberInfoVO checkAuth(HttpSession session, HttpServletResponse response);
}
