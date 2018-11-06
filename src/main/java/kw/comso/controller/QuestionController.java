//Question Controller

package kw.comso.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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

   @RequestMapping(value = "/insertquestion", method = RequestMethod.GET)
   public String loginform(ModelMap modelMap, HttpSession session) {
      // VO 객체생성
      QuestionVO questionVO = new QuestionVO();
      // Model에 VO객체 전달
      modelMap.addAttribute("questionVO", questionVO);

      // QuestionVO 등록 실패처리
      int tryRegiVal = 0;
      if (session.getAttribute("tryRegiQuestion") != null) {
         session.removeAttribute("tryRegiQuestion");
         tryRegiVal = 1;
      }
      modelMap.addAttribute("try", tryRegiVal);

      return "test/insertquestion";
   }

   @RequestMapping(value = "/questionform", method = RequestMethod.GET)
   public String questionform(ModelMap model, HttpSession session, HttpServletResponse response) {

      AuthMemberInfoVO member = memberService.checkAuth(session, response);
      if (member == null)
         return null;

      ArrayList<QuestionVO> questionList = this.questionService.getQuestion(member.getEmail());
      model.addAttribute("questionList", Util.toJson(questionList));

      return "questionform";
   }
}