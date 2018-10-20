package kw.comso.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import kw.comso.dto.AuthMemberInfoVO;
import kw.comso.dto.QuestionVO;
import kw.comso.service.MemberService;
import kw.comso.service.QuestionService;
import kw.comso.util.Util;

@Controller
public class EditorController {

	@Autowired
	QuestionService questionService;

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/inputquestion", method = RequestMethod.GET)
	public void inputTest(HttpSession session) {

		AuthMemberInfoVO member = (AuthMemberInfoVO) session.getAttribute("authMember");

		String id = "tester1";

		if (member != null)
			id = member.getEmail();

		QuestionVO q = new QuestionVO();
		q.setAnswer("1. �̰��� ���Դϴ�.");
		q.setImageLink("1. �̹��� ��ũ�� �� ���Դϴ�.");
		//q.setMulChoice("1. ��Ƽ���̽��� �Դϴ�.");
		q.setMulORSub(1);
		q.setPassage(
				"1.���� ������ �� �����Դϴ�. ��������123456789abcdef~~~~~��������123456789abcdef~~~~~��������123456789abcdef~~~~~��������123456789abcdef~~~~~��������123456789abcdef~~~~~��������123456789abcdef~~~~~��������123456789abcdef~~~~~");

		this.questionService.registerQuestion(id, q);

		q = new QuestionVO();
		q.setAnswer("2. �̰��� ���Դϴ�.");
		q.setImageLink("2. �̹��� ��ũ�� �� ���Դϴ�.");
		//q.setMulChoice("2. ��Ƽ���̽��� �Դϴ�.");
		q.setMulORSub(1);
		q.setPassage(
				"2.���� ������ �� �����Դϴ�. ��������123456789abcdef~~~~~��������123456789abcdef~~~~~��������123456789abcdef~~~~~��������123456789abcdef~~~~~��������123456789abcdef~~~~~��������123456789abcdef~~~~~��������123456789abcdef~~~~~");

		this.questionService.registerQuestion(id, q);

		q = new QuestionVO();
		q.setAnswer("3. �̰��� ���Դϴ�.");
		q.setImageLink("3. �̹��� ��ũ�� �� ���Դϴ�.");
		//q.setMulChoice("3. ��Ƽ���̽��� �Դϴ�.");
		q.setMulORSub(1);
		q.setPassage(
				"3.���� ������ �� �����Դϴ�. ��������123456789abcdef~~~~~��������123456789abcdef~~~~~��������123456789abcdef~~~~~��������123456789abcdef~~~~~��������123456789abcdef~~~~~��������123456789abcdef~~~~~��������123456789abcdef~~~~~");

		this.questionService.registerQuestion(id, q);

		q = new QuestionVO();
		q.setAnswer("4. �̰��� ���Դϴ�.");
		q.setImageLink("4. �̹��� ��ũ�� �� ���Դϴ�.");
		//q.setMulChoice("4. ��Ƽ���̽��� �Դϴ�.");
		q.setMulORSub(1);
		q.setPassage(
				"4.���� ������ �� �����Դϴ�. ��������123456789abcdef~~~~~��������123456789abcdef~~~~~��������123456789abcdef~~~~~��������123456789abcdef~~~~~��������123456789abcdef~~~~~��������123456789abcdef~~~~~��������123456789abcdef~~~~~");
		this.questionService.registerQuestion(id, q);
	}

	@RequestMapping(value = "/editor", method = RequestMethod.GET)
	public String editorTest(ModelMap model, HttpSession session, HttpServletResponse response) {

		AuthMemberInfoVO member = memberService.checkAuth(session, response);
		if (member == null)
			return null;

		ArrayList<QuestionVO> questionList = this.questionService.getQuestion(member.getEmail());
		model.addAttribute("questionList", Util.toJson(questionList));

		return "test/editortest";
	}
	
}
