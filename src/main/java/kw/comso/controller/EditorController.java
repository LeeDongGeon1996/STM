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
      q.setAnswer("1. 占싱곤옙占쏙옙 占쏙옙占쌉니댐옙.");
      q.setImageLink("1. 占싱뱄옙占쏙옙 占쏙옙크占쏙옙 占쏙옙載� 占쏙옙占쌉니댐옙.");
      //q.setMulChoice("1. 占쏙옙티占쏙옙占싱쏙옙占쏙옙 占쌉니댐옙.");
      q.setMulORSub(1);
      q.setPassage(
            "1.占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙載� 占쏙옙占쏙옙占쌉니댐옙. 占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~");

      this.questionService.registerQuestion(id, q);

      q = new QuestionVO();
      q.setAnswer("2. 占싱곤옙占쏙옙 占쏙옙占쌉니댐옙.");
      q.setImageLink("2. 占싱뱄옙占쏙옙 占쏙옙크占쏙옙 占쏙옙載� 占쏙옙占쌉니댐옙.");
      //q.setMulChoice("2. 占쏙옙티占쏙옙占싱쏙옙占쏙옙 占쌉니댐옙.");
      q.setMulORSub(1);
      q.setPassage(
            "2.占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙載� 占쏙옙占쏙옙占쌉니댐옙. 占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~");

      this.questionService.registerQuestion(id, q);

      q = new QuestionVO();
      q.setAnswer("3. 占싱곤옙占쏙옙 占쏙옙占쌉니댐옙.");
      q.setImageLink("3. 占싱뱄옙占쏙옙 占쏙옙크占쏙옙 占쏙옙載� 占쏙옙占쌉니댐옙.");
      //q.setMulChoice("3. 占쏙옙티占쏙옙占싱쏙옙占쏙옙 占쌉니댐옙.");
      q.setMulORSub(1);
      q.setPassage(
            "3.占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙載� 占쏙옙占쏙옙占쌉니댐옙. 占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~");

      this.questionService.registerQuestion(id, q);

      q = new QuestionVO();
      q.setAnswer("4. 占싱곤옙占쏙옙 占쏙옙占쌉니댐옙.");
      q.setImageLink("4. 占싱뱄옙占쏙옙 占쏙옙크占쏙옙 占쏙옙載� 占쏙옙占쌉니댐옙.");
      //q.setMulChoice("4. 占쏙옙티占쏙옙占싱쏙옙占쏙옙 占쌉니댐옙.");
      q.setMulORSub(1);
      q.setPassage(
            "4.占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙載� 占쏙옙占쏙옙占쌉니댐옙. 占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~占쏙옙占쏙옙占쏙옙占쏙옙123456789abcdef~~~~~");
      this.questionService.registerQuestion(id, q);
   }
   
   
   @RequestMapping(value = "/editor", method = RequestMethod.GET)
   public String editorTest(ModelMap model, HttpSession session, HttpServletResponse response) {

      AuthMemberInfoVO member = memberService.checkAuth(session, response);
      if (member == null)
         return null;

      ArrayList<QuestionVO> questionList = this.questionService.getQuestion(member.getEmail());
      model.addAttribute("questionList", Util.toJson(questionList));

      return "test/insertquestion";
   }
   
}