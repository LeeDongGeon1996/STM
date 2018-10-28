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

import org.apache.commons.io.IOUtils;
import org.apache.commons.codec.*;
import org.apache.commons.codec.binary.Base64;
import org.junit.runner.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private QuestionService questionService;

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/addQuestion", method = RequestMethod.GET)
	public String addQuestion(ModelMap modelMap, HttpSession session, HttpServletResponse response) {

		AuthMemberInfoVO member = memberService.checkAuth(session, response);
		if (member == null)
			return null;

		// VO ��ü����
		QuestionVO questionVO = new QuestionVO();
		// Model�� VO��ü ����
		modelMap.addAttribute("questionVO", questionVO);

		// QuestionVO ��� ����ó��
		int tryRegiVal = 0;
		if (session.getAttribute("tryRegiQuestion") != null) {
			session.removeAttribute("tryRegiQuestion");
			tryRegiVal = 1;
		}
		modelMap.addAttribute("try", tryRegiVal);

		return "addQuestionform";
	}
	@RequestMapping(value = "/addQuestion2", method = RequestMethod.GET)
	public String addQuestion2(ModelMap modelMap, HttpSession session, HttpServletResponse response) {

		AuthMemberInfoVO member = memberService.checkAuth(session, response);
		if (member == null)
			return null;

		// VO ��ü����
		QuestionVO questionVO = new QuestionVO();
		// Model�� VO��ü ����
		modelMap.addAttribute("questionVO", questionVO);

		// QuestionVO ��� ����ó��
		int tryRegiVal = 0;
		if (session.getAttribute("tryRegiQuestion") != null) {
			session.removeAttribute("tryRegiQuestion");
			tryRegiVal = 1;
		}
		modelMap.addAttribute("try", tryRegiVal);

		return "addQuestionform2";
	}

	// 제작된 문제 이미지캡쳐 컨트롤러
	@RequestMapping(value = "/captureQuestion", method = RequestMethod.POST)
	public void captureQuestion(QuestionVO questionVO, ModelMap modelMap, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {
		boolean isSucceed = false;
		String uuid = getUuid();

		Path path = Paths.get("C:\\Users\\junma\\Desktop\\capimgPath\\" + uuid + ".png");
		String pathwd = "C:\\Users\\junma\\Desktop\\capimgPath\\" + uuid + ".png";
		File addfile = new File(pathwd);

		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(addfile, true));

			// 파일안에 문자열 쓰기

			fw.flush();

			// 객체 닫기
			fw.close();

			// 이미지 정보 받아오기 && 불필요한 정보 제거
			String capimgData = request.getParameter("capimgData");
			System.out.print(capimgData);
			capimgData = capimgData.replaceAll("data:image/png;base64,", "");
			// 이미지 디코딩(codec 라이브러리 사용 - base64)
			byte[] file = Base64.decodeBase64(capimgData);
			ByteArrayInputStream is = new ByteArrayInputStream(file);

			// 이미지 정보 재작성
			response.setContentType("image/png");
			response.setHeader("Content-Disposition", "attachment; filename=" + uuid + ".png");

			// 이미지 서버 업로드
			Files.copy(is, path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		AuthMemberInfoVO member = memberService.checkAuth(session, response);
		questionVO.setCapImageLink("http://localhost:8181/st2m/capimg" + "/" + uuid + ".png");
		System.out.println(questionVO.getCapImageLink());
		isSucceed = questionService.registerQuestion(member.getEmail(), questionVO);

	}

	@RequestMapping(value = "/registerQuestion")
	public Map registerQuestion(QuestionVO questionVO, ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		boolean isSucceed = false;

		AuthMemberInfoVO member = memberService.checkAuth(session, response);

		String uuid = getUuid();

		Path cap_path = Paths.get("C:\\Users\\junma\\Desktop\\capimgPath\\" + uuid + ".png");
		String pathwd = "C:\\Users\\junma\\Desktop\\capimgPath\\" + uuid + ".png";
		File addfile = new File(pathwd);

		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(addfile, true));

			// 파일안에 문자열 쓰기

			fw.flush();

			// 객체 닫기
			fw.close();

			// 이미지 정보 받아오기 && 불필요한 정보 제거
			String capimgData = questionVO.getCapValue();
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
		
		questionVO.setCapImageLink("http://localhost:8181/st2m/capimg" + "/" + uuid + ".png");
		System.out.println(questionVO.getCapImageLink());

		// �̹���
		String path = "C:\\Users\\junma\\Desktop\\imgPath";
		System.out.println(path);
		Map returnObject = new HashMap();

		try {
			// multiparthttpservletrequest ����
			MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
			Iterator iter = mhsr.getFileNames();

			MultipartFile mfile = null;
			String fieldName = "";
			List resultList = new ArrayList();

			// ���丮�� ���ٸ� �����Ѵ�
			File dir = new File(path);
			if (!dir.isDirectory()) {
				dir.mkdirs();
			}

			// ���� ���ö�����
			while (iter.hasNext()) {
				fieldName = (String) iter.next();
				mfile = mhsr.getFile(fieldName);
				String origName;

				origName = new String(mfile.getOriginalFilename().getBytes("8859_1"), "UTF-8");// �ѱ� �������� �ڵ�

				// ���ϸ��� ���ٸ�
				if ("".equals(origName)) {
					continue;
				}

				// ���� �� ���� (uuid�� ��ȣȭ)
				String ext = origName.substring(origName.lastIndexOf('.'));
				String saveFileName = getUuid() + ext;

				// ������ path�� ��������
				File serverFile = new File(path + File.separator + saveFileName);
				mfile.transferTo(serverFile);

				questionVO.setImageLink("http://localhost:8181/st2m/img" + "/" + saveFileName);

				System.out.println(questionVO.getImageLink());

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

		isSucceed = questionService.registerQuestion(member.getEmail(), questionVO);
		if (isSucceed) {
			Util.sendRedirect(response, "questionform");
		} else {
			session.setAttribute("tryRegiQuestion", questionVO);
			Util.sendRedirect(response, "questionform");
		}

		return null;
	}

	/*
	 * @RequestMapping(value = "/fileUpload") public Map
	 * fileUpload(HttpServletRequest req, HttpServletResponse rep, HttpSession
	 * session) {
	 * 
	 * String path = "C:\\Users\\junma\\Desktop\\imgPath"; System.out.println(path);
	 * Map returnObject = new HashMap();
	 * 
	 * try { // multiparthttpservletrequest ���� MultipartHttpServletRequest mhsr =
	 * (MultipartHttpServletRequest) req; Iterator iter = mhsr.getFileNames();
	 * 
	 * MultipartFile mfile = null; String fieldName = ""; List resultList = new
	 * ArrayList();
	 * 
	 * // ���丮�� ���ٸ� �����Ѵ� File dir = new File(path); if (!dir.isDirectory()) {
	 * dir.mkdirs(); }
	 * 
	 * // ���� ���ö����� while (iter.hasNext()) { fieldName = (String) iter.next();
	 * mfile = mhsr.getFile(fieldName); String origName;
	 * 
	 * origName = new String(mfile.getOriginalFilename().getBytes("8859_1"),
	 * "UTF-8");// �ѱ� �������� �ڵ�
	 * 
	 * // ���ϸ��� ���ٸ� if ("".equals(origName)) { continue; }
	 * 
	 * // ���� �� ���� (uuid�� ��ȣȭ) String ext =
	 * origName.substring(origName.lastIndexOf('.')); String saveFileName =
	 * getUuid() + ext;
	 * 
	 * // ������ path�� �������� File serverFile = new File(path + File.separator +
	 * saveFileName); mfile.transferTo(serverFile);
	 * 
	 * AuthMemberInfoVO member = memberService.checkAuth(session, rep); if (member
	 * == null) return null;
	 * 
	 * QuestionVO q = new QuestionVO();
	 * q.setImageLink("http://localhost:8181/st2m/img" + "/" + saveFileName);
	 * 
	 * System.out.println(q.getImageLink());
	 * 
	 * questionService.registerQuestion(member.getEmail(), q);
	 * 
	 * }
	 * 
	 * returnObject.put("files", resultList); returnObject.put("params",
	 * mhsr.getParameterMap());
	 * 
	 * } catch (UnsupportedEncodingException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IllegalStateException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch (IOException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * Util.sendRedirect(rep, "testImg"); return null;
	 * 
	 * }
	 */
	// uuid ����
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
