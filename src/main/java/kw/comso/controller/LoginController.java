package kw.comso.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
	public String loginform(ModelMap modelMap) {
		// VO ��ü����
		MemberInfoVO infoVO = new MemberInfoVO();
		// Model�� VO��ü ����
		modelMap.addAttribute("infoVO", infoVO);

		return "loginform";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(MemberInfoVO infoVO, HttpSession session, HttpServletResponse response) {
		boolean is;

		if (this.memberService.checkPassword(infoVO)) {
			AuthMemberInfoVO authMember = new AuthMemberInfoVO();
			authMember.setEmail(infoVO.getEmail());
			authMember.setAuth(infoVO.getAuth());

			session.setAttribute("authMember", authMember);

			Util.sendRedirect(response, "home");
		} else {
			System.out.println("����");
			Util.sendRedirect(response, "loginform");
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public void logout(HttpSession session, HttpServletResponse response) {

		session.invalidate();
		Util.sendRedirect(response, "loginform");

	}

	@RequestMapping(value = "/home", method = { RequestMethod.POST, RequestMethod.GET })
	public String home(MemberInfoVO infoVO, ModelMap modelMap) {
		boolean is;

		modelMap.addAttribute("name", infoVO.getUserName());
		modelMap.addAttribute("password", infoVO.getPassword());
		is = memberService.registerMember(infoVO);
		System.out.println(is);

		System.out.println("id=" + infoVO.getUserName());
		System.out.println("pw=" + infoVO.getPassword());
		return "home";
	}
}
