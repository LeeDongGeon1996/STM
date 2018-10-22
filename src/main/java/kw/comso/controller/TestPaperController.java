package kw.comso.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kw.comso.dto.AuthMemberInfoVO;
import kw.comso.dto.QuestionVO;
import kw.comso.service.MemberService;
import kw.comso.service.QuestionService;
import kw.comso.util.Util;

@Controller
public class TestPaperController {
	@Autowired
	private QuestionService questionService;

	@Autowired
	private MemberService memberService;

	@RequestMapping(value="/testpaper_editor", method= RequestMethod.GET)
	public String editTestPaper(ModelMap model, HttpSession session, HttpServletResponse response) {
		
		//로그인 확인
		AuthMemberInfoVO member = memberService.checkAuth(session, response);
		if (member == null)
			return null;
		
		//로그인한 회원의 모든 문제 검색
		ArrayList<QuestionVO> questionList = this.questionService.getQuestion(member.getEmail());
		model.addAttribute("questionList", Util.toJson(questionList));
		
		//시험지생성페이지의 jsp를 반환한다.
		return "addTestform";
	}
	
	@RequestMapping(value="/save_testpaper", method= RequestMethod.POST)
	public String saveTestPaper(ModelMap model, HttpSession session, HttpServletResponse response) {
		
		//로그인 확인
		AuthMemberInfoVO member = memberService.checkAuth(session, response);
		if (member == null)
			return null;
		
		//사용자측으로부터 받은 시험지의 문항목록을 저장.
		
		
		
		//시험지생성페이지의 jsp를 반환한다.
		return null;
	}

}
