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
		
		//占싸깍옙占쏙옙 확占쏙옙
		AuthMemberInfoVO member = memberService.checkAuth(session, response);
		if (member == null)
			return null;
		
		//占싸깍옙占쏙옙占쏙옙 회占쏙옙占쏙옙 占쏙옙占� 占쏙옙占쏙옙 占싯삼옙
		ArrayList<QuestionVO> questionList = this.questionService.getQuestion(member.getEmail());
		model.addAttribute("questionList", Util.toJson(questionList));
		
		TestPaperVO testpaperVO = new TestPaperVO();
		model.addAttribute("testpaperVO",testpaperVO);
		
		//占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 jsp占쏙옙 占쏙옙환占싼댐옙.
		return "addTestform";
	}
	
	@RequestMapping(value = "/save_testpaper", method = RequestMethod.POST)
	   public String saveTestPaper(ModelMap model, HttpSession session, HttpServletResponse response,
	         TestPaperVO testPaper) {

	      // 濡쒓렇�씤 �솗�씤
	      AuthMemberInfoVO member = memberService.checkAuth(session, response);
	      if (member == null)
	         return null;

	      // �궗�슜�옄痢≪쑝濡쒕��꽣 諛쏆� �떆�뿕吏��쓽 臾명빆紐⑸줉�쓣 ���옣.
	      testPaper.setHtml(testPaper.getHtml().replaceAll(" ", "").replaceAll("\n", ""));
	      boolean isSucceed = questionService.registerTestPaper(member.getEmail(), testPaper);
	      //���옣 �떎�뙣 泥섎━
	      /*
	      if (isSucceed) {
	         Util.sendRedirect(response, "testpaper_editor");
	      } else {
	         session.setAttribute("tryRegiTestPaper", testPaper);
	         Util.sendRedirect(response, "testpaper_editor");
	      }
	       */
	      // �떆�뿕吏��깮�꽦�럹�씠吏��쓽 jsp瑜� 諛섑솚�븳�떎.
	      Util.sendRedirect(response, "testpaper_editor");
	      
	      return null;
	   }
	
	@RequestMapping(value = "/registerTest")
	public Map registerTest(TestPaperVO testpaperVO, ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		boolean isSucceed = false;

		AuthMemberInfoVO member = memberService.checkAuth(session, response);

		String uuid = getUuid();

		Path cap_path = Paths.get("C:\\Users\\KHR\\Desktop\\captestimgPath\\" + uuid + ".png");
		String pathwd = "C:\\Users\\KHR\\Desktop\\captestimgPath\\" + uuid + ".png";
		File addfile = new File(pathwd);

		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(addfile, true));

			// �뙆�씪�븞�뿉 臾몄옄�뿴 �벐湲�

			fw.flush();

			// 媛앹껜 �떕湲�
			fw.close();

			// �씠誘몄� �젙蹂� 諛쏆븘�삤湲� && 遺덊븘�슂�븳 �젙蹂� �젣嫄�
			String capimgData = testpaperVO.getCapTestValue();
			System.out.print(capimgData);
			capimgData = capimgData.replaceAll("data:image/png;base64,", "");
			// �씠誘몄� �뵒肄붾뵫(codec �씪�씠釉뚮윭由� �궗�슜 - base64)
			byte[] file = Base64.decodeBase64(capimgData);
			ByteArrayInputStream is = new ByteArrayInputStream(file);

			// �씠誘몄� �젙蹂� �옱�옉�꽦
			response.setContentType("image/png");
			response.setHeader("Content-Disposition", "attachment; filename=" + uuid + ".png");

			// �씠誘몄� �꽌踰� �뾽濡쒕뱶
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

		return "testform";
	}
	
	@RequestMapping(value="/test_download")
	public void test_download() {
		
	}
	
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
