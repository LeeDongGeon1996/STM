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
		
		//�α��� Ȯ��
		AuthMemberInfoVO member = memberService.checkAuth(session, response);
		if (member == null)
			return null;
		
		//�α����� ȸ���� ��� ���� �˻�
		ArrayList<QuestionVO> questionList = this.questionService.getQuestion(member.getEmail());
		model.addAttribute("questionList", Util.toJson(questionList));
		
		//������������������ jsp�� ��ȯ�Ѵ�.
		return "addTestform";
	}
	
	@RequestMapping(value="/save_testpaper", method= RequestMethod.POST)
	public String saveTestPaper(ModelMap model, HttpSession session, HttpServletResponse response) {
		
		//�α��� Ȯ��
		AuthMemberInfoVO member = memberService.checkAuth(session, response);
		if (member == null)
			return null;
		
		//����������κ��� ���� �������� ���׸���� ����.
		
		
		
		//������������������ jsp�� ��ȯ�Ѵ�.
		return null;
	}

}
