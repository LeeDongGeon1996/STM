package kw.comso.controller;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kw.comso.dto.AuthMemberInfoVO;
import kw.comso.dto.QuestionVO;
import kw.comso.dto.TestPaperVO;
import kw.comso.dao.TestPaperDAO;
import kw.comso.dao.impl.TestPaperDAOImpl;
import kw.comso.service.MemberService;
import kw.comso.service.QuestionService;
import kw.comso.util.Util;

@Controller
public class TestPaperController {
	@Autowired
	private QuestionService questionService;

	@Autowired
	private MemberService memberService;

	@RequestMapping(value="/addtestform", method= RequestMethod.GET)
	public String editTestPaper(ModelMap model, HttpSession session, HttpServletResponse response) {
		
		//�α��� Ȯ��
		AuthMemberInfoVO member = memberService.checkAuth(session, response);
		if (member == null)
			return null;
		
		//�α����� ȸ���� ��� ���� �˻�
		ArrayList<QuestionVO> questionList = this.questionService.getQuestion(member.getEmail());
		model.addAttribute("questionList", Util.toJson(questionList));
		
		TestPaperVO testpaperVO = new TestPaperVO();
		model.addAttribute("testpaperVO",testpaperVO);
		
		//������������������ jsp�� ��ȯ�Ѵ�.
		return "addTestform";
	}
	
	@Autowired
	   private TestPaperDAO testPaperDAO;
	
	@RequestMapping(value="/edittestform")
	public String editOldTestPaper(ModelMap model, HttpSession session, HttpServletResponse response, TestPaperVO testpaperVO) {
		
		//�α��� Ȯ��
		AuthMemberInfoVO member = memberService.checkAuth(session, response);
		
		if (member == null)
			return null;
		System.out.println("hello"+testpaperVO.getTestPaperIDNum()+"hihi");
		String testId = testpaperVO.getTestPaperIDNum();
		
		testpaperVO=questionService.getTestPaper_one(testId);
		model.addAttribute("testpaperVO",testpaperVO);
		
		ArrayList<QuestionVO> questionList = this.questionService.getQuestion(member.getEmail());
		model.addAttribute("questionList", Util.toJson(questionList));
		
		
		//������������������ jsp�� ��ȯ�Ѵ�.
		return "addTestform";
	}
	
	@RequestMapping(value = "/save_testpaper", method = RequestMethod.POST)
	   public String saveTestPaper(ModelMap model, HttpSession session, HttpServletResponse response,
	         TestPaperVO testPaper) {

	      // 로그인 확인
	      AuthMemberInfoVO member = memberService.checkAuth(session, response);
	      if (member == null)
	         return null;

	      // 사용자측으로부터 받은 시험지의 문항목록을 저장.
	      testPaper.setHtml(testPaper.getHtml().replaceAll(" ", "").replaceAll("\n", ""));
	      boolean isSucceed = questionService.registerTestPaper(member.getEmail(), testPaper);
	      //저장 실패 처리
	      /*
	      if (isSucceed) {
	         Util.sendRedirect(response, "testpaper_editor");
	      } else {
	         session.setAttribute("tryRegiTestPaper", testPaper);
	         Util.sendRedirect(response, "testpaper_editor");
	      }
	       */
	      // 시험지생성페이지의 jsp를 반환한다.
	      Util.sendRedirect(response, "testpaper_editor");
	      
	      return null;
	   }
	
	@RequestMapping(value = "/registerTest")
	public Map registerTest(TestPaperVO testpaperVO, ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		boolean isSucceed = false;

		AuthMemberInfoVO member = memberService.checkAuth(session, response);

		String uuid = getUuid();

		Path cap_path = Paths.get("C:\\Users\\junma\\Desktop\\captestimgPath\\" + uuid + ".png");
		String pathwd = "C:\\Users\\junma\\Desktop\\captestimgPath\\" + uuid + ".png";
		File addfile = new File(pathwd);

		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(addfile, true));

			// 파일안에 문자열 쓰기

			fw.flush();

			// 객체 닫기
			fw.close();

			// 이미지 정보 받아오기 && 불필요한 정보 제거
			String capimgData = testpaperVO.getCapTestValue();
			System.out.print(capimgData);
			capimgData = capimgData.replaceAll("data:image/png;base64,", "");
			// 이미지 디코딩(codec 라이브러리 사용 - base64)
			byte[] file = Base64.decodeBase64(capimgData);
			ByteArrayInputStream is = new ByteArrayInputStream(file);

			// 이미지 정보 재작성
			response.setContentType("image/png");
			response.setHeader("Content-Disposition", "attachment; filename=" + uuid + ".png");

			// 이미지 서버 업로드
			Files.copy(is, cap_path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		testpaperVO.setCapTestLink("http://localhost:8181/st2m/captestimg" + "/" + uuid + ".png");
		System.out.println(testpaperVO.getCapTestLink());

		
		testpaperVO.setHtml(testpaperVO.getHtml().replaceAll(" ", "").replaceAll("\n", ""));
		isSucceed = questionService.registerTestPaper(member.getEmail(), testpaperVO);
		System.out.println("here");
		if (isSucceed) {
			Util.sendRedirect(response, "testform");
		} else {
			//session.setAttribute("tryRegiQuestion", questionVO);
			Util.sendRedirect(response, "testform");
		}

		return null;
	}
	
	@RequestMapping(value = "/testform")
	public String testform(ModelMap model,HttpSession session, HttpServletResponse response) {
		
		AuthMemberInfoVO member = memberService.checkAuth(session, response);
		if (member == null)
			return null;

		ArrayList<TestPaperVO> testList = this.questionService.getTestPaper(member.getEmail());
		model.addAttribute("testList", Util.toJson(testList));
		
		TestPaperVO testpaperVO = new TestPaperVO();
		model.addAttribute("testpaperVO",testpaperVO);

		return "testform";
	}
	
	@RequestMapping(value="/test_download")
	public void test_download() {
		
	}
	
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
