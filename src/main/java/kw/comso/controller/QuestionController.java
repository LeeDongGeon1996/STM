package kw.comso.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	@RequestMapping(value = "/registerquestion", method = RequestMethod.POST)
	public void registerquestion(QuestionVO questionVO, HttpSession session, HttpServletRequest req,
			HttpServletResponse response) {

		boolean isSucceed = false;

		AuthMemberInfoVO member = memberService.checkAuth(session, response);
		if (member == null)
			return;

		String path = req.getSession().getServletContext().getRealPath("/webapp/resources/testImg");
		System.out.println(path);
		Map returnObject = new HashMap();

		try {
			// multiparthttpservletrequest 생성
			MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) req;
			Iterator iter = mhsr.getFileNames();

			MultipartFile mfile = null;
			String fieldName = "";
			List resultList = new ArrayList();

			// 디렉토리가 없다면 생성한다
			File dir = new File(path);
			if (!dir.isDirectory()) {
				dir.mkdirs();
			}

			// 값이 나올때까지
			while (iter.hasNext()) {
				fieldName = (String) iter.next();
				mfile = mhsr.getFile(fieldName);
				String origName;

				origName = new String(mfile.getOriginalFilename().getBytes("8859_1"), "UTF-8");// 한글 깨짐방지 코드

				// 파일명이 없다면
				if ("".equals(origName)) {
					continue;
				}

				// 파일 명 변경 (uuid로 암호화)
				String ext = origName.substring(origName.lastIndexOf('.'));
				String saveFileName = getUuid() + ext;

				// 설정한 path에 파일저장
				File serverFile = new File(path + File.separator + saveFileName);
				mfile.transferTo(serverFile);

				Map file = new HashMap();
				file.put("origName", origName);
				file.put("sfile", serverFile);
				resultList.add(file);

				questionVO.setImageLink("" + serverFile);
				
			}

			returnObject.put("files", resultList);
			returnObject.put("params", mhsr.getParameterMap());

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 등록실패 처리
		isSucceed = questionService.registerQuestion(member.getEmail(), questionVO);
		if (isSucceed) {
			Util.sendRedirect(response, "home");
		} else {
			session.setAttribute("tryRegiQuestion", questionVO);
			Util.sendRedirect(response, "insertquestion");
		}

	}

	//uuid 생성
		public static String getUuid() {
			return UUID.randomUUID().toString().replaceAll("-","");
		}
}
