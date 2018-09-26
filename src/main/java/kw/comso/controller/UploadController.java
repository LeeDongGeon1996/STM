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

import kw.comso.dto.MemberInfoVO;
import kw.comso.dto.QuestionVO;
import kw.comso.service.QuestionService;

@Controller
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value = "/testImg", method = RequestMethod.GET)
	public String testImg(HttpSession session) {
		
		
		return "fileupload";
	}
	
	@RequestMapping(value = "/fileUpload")
	public Map fileUpload(HttpServletRequest req, HttpServletResponse rep) {
		
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
				
				QuestionVO q = new QuestionVO();
				q.setImageLink(""+serverFile);
				
				System.out.println(q.getImageLink());
				
				questionService.registerQuestion("",q);

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
		
		return null;
		
	}
	
	//uuid ����
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-","");
	}
}
