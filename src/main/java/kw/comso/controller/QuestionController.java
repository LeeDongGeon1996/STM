package kw.comso.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kw.comso.dto.AuthMemberInfoVO;
import kw.comso.dto.MemberInfoVO;
import kw.comso.dto.QuestionVO;
import kw.comso.service.MemberService;
import kw.comso.service.QuestionService;
import kw.comso.util.Util;

@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/insertquestion", method=RequestMethod.GET)
	public String loginform(ModelMap modelMap, HttpSession session) {
		// VO 객체생성
		QuestionVO questionVO = new QuestionVO();
		// Model에 VO객체 전달
		modelMap.addAttribute("questionVO", questionVO);
		
		//QuestionVO 등록 실패처리
		int tryRegiVal = 0;
		if(session.getAttribute("tryRegiQuestion") != null) {
			session.removeAttribute("tryRegiQuestion");
			tryRegiVal  = 1;
		}
		modelMap.addAttribute("try", tryRegiVal);

		return "insertquestion";
	}

	@RequestMapping(value = "/registerquestion", method = RequestMethod.POST)
	public void registerQuestion(QuestionVO questionVO, HttpSession session, HttpServletResponse response) {
	
		boolean isSucceed = false;
		
		AuthMemberInfoVO member = memberService.checkAuth(session, response);
		if (member == null)
			return;
		
		//등록실패 처리
		isSucceed = questionService.registerQuestion(member.getEmail(), questionVO);
		if(isSucceed) {
			Util.sendRedirect(response, "home");
		} else {
			session.setAttribute("tryRegiQuestion", questionVO);
			Util.sendRedirect(response, "insertquestion");
		}
		
	}

}
