package kw.comso.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import kw.comso.dao.MemberInfoDAO;
import kw.comso.dao.MemberRelationDAO;
import kw.comso.dto.MemberInfoVO;
import kw.comso.service.MemberService;

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

		if (check_pw(member))
			return memberInfoDAO.removeMemberInfo(member);
		
		return false;
	}

	@Override
	public boolean updateMember(MemberInfoVO member) {

		return true;
		// return memberRelationDAO.updateMemberRelation(memrel, update2);

	}

	private boolean check_pw(MemberInfoVO member) {

		MemberInfoVO account = this.memberInfoDAO.findOne("email", member.getEmail());
		if (account != null) {
			return member.getPassword() == account.getPassword();
		}

		return false;
	}

}
