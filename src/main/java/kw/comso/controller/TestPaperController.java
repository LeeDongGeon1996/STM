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

		isSucceed = questionService.registerTestPaper(member.getEmail(), testpaperVO);
		System.out.println("here");
		if (isSucceed) {
			Util.sendRedirect(response, "addtestform");
		} else {
			//session.setAttribute("tryRegiQuestion", questionVO);
			Util.sendRedirect(response, "addtestform");
		}

		return null;
	}
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
