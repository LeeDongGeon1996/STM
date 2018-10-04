package kw.comso.service.impl;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import kw.comso.dao.MemberInfoDAO;
import kw.comso.dao.MemberRelationDAO;
import kw.comso.dto.AuthMemberInfoVO;
import kw.comso.dto.MemberInfoVO;
import kw.comso.service.MemberService;
import kw.comso.util.Util;

public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberInfoDAO memberInfoDAO;

	@Autowired
	MemberRelationDAO memberRelationDAO;

	public void setMemberInfoDAO(MemberInfoDAO memberInfoDAO) {
		this.memberInfoDAO = memberInfoDAO;
	}

	public void setMemberRelationDAO(MemberRelationDAO memberRelationDAO) {
		this.memberRelationDAO = memberRelationDAO;
	}

	@Override
	public boolean registerMember(MemberInfoVO member) {

		// duplication check
		MemberInfoVO dup = this.memberInfoDAO.findOne("email", member.getEmail());
		if (dup != null)
			return false;

		return memberInfoDAO.insertMemberInfo(member);

	}

	@Override
	public boolean deleteMember(MemberInfoVO member) {

		if (checkPassword(member) != null)
			return memberInfoDAO.removeMemberInfo(member);

		return false;
	}

	@Override
	public boolean updateMember(MemberInfoVO member) {

		return true;
		// return memberRelationDAO.updateMemberRelation(memrel, update2);

	}

	@Override
	public MemberInfoVO checkPassword(MemberInfoVO member) {

		MemberInfoVO account = this.memberInfoDAO.findOne("email", member.getEmail(),
				new String[] { "email", "password", "userName" });
		if (account != null) {
			if (member.getPassword().equals(account.getPassword())) {
				return account;
			}
		}

		return null;
	}

	@Override
	public AuthMemberInfoVO checkAuth(HttpSession session, HttpServletResponse response) {

		AuthMemberInfoVO member = (AuthMemberInfoVO) session.getAttribute("authMember");

		if (member == null)
			Util.sendRedirect(response, "loginform");

		// ����üũ�� �������...(�����ؾ���)
		// ���ѿ��������� ������ �����̷������ְ� member�� null�� �ʱ�ȭ�ؼ� ���ϵǵ���.

		return member;

	}
}
