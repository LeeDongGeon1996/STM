package kw.comso.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kw.comso.dto.AuthMemberInfoVO;
import kw.comso.dto.MemberInfoVO;
import kw.comso.service.MemberService;
import kw.comso.util.Util;

@Controller
public class LoginController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/loginform", method = RequestMethod.GET)
	public String loginform(ModelMap modelMap, HttpSession session) {
		// VO ��ü����
		MemberInfoVO infoVO = new MemberInfoVO();
		// Model�� VO��ü ����
		modelMap.addAttribute("infoVO", infoVO);

		// �α��� ����ó��
		int tryLoginVal = 0;
		if (session.getAttribute("tryLogin") != null) {
			session.removeAttribute("tryLogin");
			tryLoginVal = 1;
		}
		modelMap.addAttribute("try", tryLoginVal);

		return "loginform";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(MemberInfoVO infoVO, HttpSession session, HttpServletResponse response) {
		boolean is;

		MemberInfoVO userAccount = this.memberService.checkPassword(infoVO);
		if (userAccount != null) {
			AuthMemberInfoVO authMember = new AuthMemberInfoVO();
			authMember.setEmail(userAccount.getEmail());
			authMember.setAuth(userAccount.getAuth());
			authMember.setUserName(userAccount.getUserName());

			session.setAttribute("authMember", authMember);

			Util.sendRedirect(response, "home");
		} else {
			System.out.println("����");
			session.setAttribute("tryLogin", infoVO);
			Util.sendRedirect(response, "loginform");
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public void logout(HttpSession session, HttpServletResponse response) {

		session.invalidate();
		Util.sendRedirect(response, "loginform");

	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap modelMap, HttpSession session, HttpServletResponse response) {

		AuthMemberInfoVO member = memberService.checkAuth(session, response);
		if (member == null)
			return null;

		modelMap.addAttribute("userName", member.getUserName());
		System.out.println("===========Login===============");
		System.out.println("userName=" + member.getUserName());
		System.out.println("Email=" + member.getEmail());
		return "home_renual";
	}
}