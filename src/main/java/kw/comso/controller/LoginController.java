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

@Controller
public class LoginController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/loginform", method = RequestMethod.GET)
	public String loginform(ModelMap modelMap) {
		// VO 객체생성
		MemberInfoVO infoVO = new MemberInfoVO();
		// Model에 VO객체 전달
		modelMap.addAttribute("infoVO", infoVO);

		return "loginform";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(MemberInfoVO infoVO, HttpSession session, HttpServletResponse response) {
		boolean is;

		try {
			if (this.memberService.checkPassword(infoVO)) {
				AuthMemberInfoVO authMember = new AuthMemberInfoVO();
				authMember.setEmail(infoVO.getEmail());
				authMember.setAuth(infoVO.getAuth());

				session.setAttribute("authMember", authMember);

				response.sendRedirect("home");
			} else {
				System.out.println("실패");
				response.sendRedirect("loginform");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public void logout(HttpSession session, HttpServletResponse response) {
		try {
			session.invalidate();
			response.sendRedirect("loginform");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
