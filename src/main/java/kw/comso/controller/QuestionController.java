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
			// multiparthttpservletrequest ����
			MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) req;
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

		// ��Ͻ��� ó��
		isSucceed = questionService.registerQuestion(member.getEmail(), questionVO);
		if (isSucceed) {
			Util.sendRedirect(response, "home");
		} else {
			session.setAttribute("tryRegiQuestion", questionVO);
			Util.sendRedirect(response, "insertquestion");
		}

	}

	//uuid ����
		public static String getUuid() {
			return UUID.randomUUID().toString().replaceAll("-","");
		}
}
