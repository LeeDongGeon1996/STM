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
	public String addQuestion(ModelMap modelMap, HttpSession session,HttpServletResponse response) {
		
		AuthMemberInfoVO member = memberService.checkAuth(session, response);
		if(member==null)
			return null;
		
		// VO 占쏙옙체占쏙옙占쏙옙
		QuestionVO questionVO = new QuestionVO();
		// Model占쏙옙 VO占쏙옙체 占쏙옙占쏙옙
		modelMap.addAttribute("questionVO", questionVO);

		// QuestionVO 占쏙옙占� 占쏙옙占쏙옙처占쏙옙
		int tryRegiVal = 0;
		if (session.getAttribute("tryRegiQuestion") != null) {
			session.removeAttribute("tryRegiQuestion");
			tryRegiVal = 1;
		}
		modelMap.addAttribute("try", tryRegiVal);
		
		return "addQuestionform";
	}
	
	//�젣�옉�맂 臾몄젣 �씠誘몄�罹≪퀜 而⑦듃濡ㅻ윭
	@RequestMapping(value = "/captureQuestion", method = RequestMethod.POST)
    public void captureQuestion(QuestionVO questionVO, ModelMap modelMap, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		boolean isSucceed = false;
		String uuid=getUuid();
        
		Path path = Paths.get("C:\\Users\\matth\\Desktop\\capimgPath\\"+uuid+".png");
		String pathwd="C:\\Users\\matth\\Desktop\\capimgPath\\"+uuid+".png";
		File addfile = new File(pathwd);
		
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(addfile, true));
            
            // �뙆�씪�븞�뿉 臾몄옄�뿴 �벐湲�
            
            fw.flush();
 
            // 媛앹껜 �떕湲�
            fw.close();

        	//�씠誘몄� �젙蹂� 諛쏆븘�삤湲� && 遺덊븘�슂�븳 �젙蹂� �젣嫄�
            String capimgData = request.getParameter("capimgData");
            capimgData = capimgData.replaceAll("data:image/png;base64,", "");
            //�씠誘몄� �뵒肄붾뵫(codec �씪�씠釉뚮윭由� �궗�슜 - base64)
            byte[] file = Base64.decodeBase64(capimgData);
            ByteArrayInputStream is = new ByteArrayInputStream(file);
            
            //�씠誘몄� �젙蹂� �옱�옉�꽦
            response.setContentType("image/png");
            response.setHeader("Content-Disposition", "attachment; filename="+uuid+".png");
            
            //�씠誘몄� �꽌踰� �뾽濡쒕뱶
            Files.copy(is, path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            // TODO Auto-generated catch block   
        }
		AuthMemberInfoVO member = memberService.checkAuth(session, response);
		questionVO.setCapImageLink("http://localhost:8080/st2m/capimg" + "/" + uuid+".png");
		System.out.println(questionVO.getCapImageLink());
		isSucceed = questionService.registerQuestion(member.getEmail(), questionVO);
		
    }

	@RequestMapping(value = "/registerQuestion")
	public Map registerQuestion(QuestionVO questionVO, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		boolean isSucceed = false;

		AuthMemberInfoVO member = memberService.checkAuth(session, response);


		// 占쌔쏙옙트

		// 占싱뱄옙占쏙옙
		String path = "C:\\Users\\matth\\Desktop\\imgPath";
		System.out.println(path);
		Map returnObject = new HashMap();

		try {
			// multiparthttpservletrequest 占쏙옙占쏙옙
			MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
			Iterator iter = mhsr.getFileNames();

			MultipartFile mfile = null;
			String fieldName = "";
			List resultList = new ArrayList();

			// 占쏙옙占썰리占쏙옙 占쏙옙占쌕몌옙 占쏙옙占쏙옙占싼댐옙
			File dir = new File(path);
			if (!dir.isDirectory()) {
				dir.mkdirs();
			}

			// 占쏙옙占쏙옙 占쏙옙占시띰옙占쏙옙占쏙옙
			while (iter.hasNext()) {
				fieldName = (String) iter.next();
				mfile = mhsr.getFile(fieldName);
				String origName;

				origName = new String(mfile.getOriginalFilename().getBytes("8859_1"), "UTF-8");// 占싼깍옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쌘듸옙

				// 占쏙옙占싹몌옙占쏙옙 占쏙옙占쌕몌옙
				if ("".equals(origName)) {
					continue;
				}

				// 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙 (uuid占쏙옙 占쏙옙호화)
				String ext = origName.substring(origName.lastIndexOf('.'));
				String saveFileName = getUuid() + ext;

				// 占쏙옙占쏙옙占쏙옙 path占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙
				File serverFile = new File(path + File.separator + saveFileName);
				mfile.transferTo(serverFile);
			
				questionVO.setImageLink("http://localhost:8080/st2m/img" + "/" + saveFileName);

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
			Util.sendRedirect(response, "addQuestion");
		} else {
			session.setAttribute("tryRegiQuestion", questionVO);
			Util.sendRedirect(response, "addQuestion");
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
	 * try { // multiparthttpservletrequest 占쏙옙占쏙옙 MultipartHttpServletRequest mhsr =
	 * (MultipartHttpServletRequest) req; Iterator iter = mhsr.getFileNames();
	 * 
	 * MultipartFile mfile = null; String fieldName = ""; List resultList = new
	 * ArrayList();
	 * 
	 * // 占쏙옙占썰리占쏙옙 占쏙옙占쌕몌옙 占쏙옙占쏙옙占싼댐옙 File dir = new File(path); if (!dir.isDirectory()) {
	 * dir.mkdirs(); }
	 * 
	 * // 占쏙옙占쏙옙 占쏙옙占시띰옙占쏙옙占쏙옙 while (iter.hasNext()) { fieldName = (String) iter.next(); mfile
	 * = mhsr.getFile(fieldName); String origName;
	 * 
	 * origName = new String(mfile.getOriginalFilename().getBytes("8859_1"),
	 * "UTF-8");// 占싼깍옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쌘듸옙
	 * 
	 * // 占쏙옙占싹몌옙占쏙옙 占쏙옙占쌕몌옙 if ("".equals(origName)) { continue; }
	 * 
	 * // 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙 (uuid占쏙옙 占쏙옙호화) String ext =
	 * origName.substring(origName.lastIndexOf('.')); String saveFileName =
	 * getUuid() + ext;
	 * 
	 * // 占쏙옙占쏙옙占쏙옙 path占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 File serverFile = new File(path + File.separator +
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
	// uuid 占쏙옙占쏙옙
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}