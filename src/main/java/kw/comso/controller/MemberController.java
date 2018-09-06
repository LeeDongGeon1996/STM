package kw.comso.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kw.comso.service.MemberService;
import kw.comso.dto.*;

@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/insertinfo", method = RequestMethod.GET)
	public String insertinfo(ModelMap modelMap) {
		// VO 按眉积己
		MemberInfoVO infoVO = new MemberInfoVO();
		// Model俊 VO按眉 傈崔
		modelMap.addAttribute("infoVO", infoVO);

		return "test";
	}

	@RequestMapping(value = "/getinfo", method = { RequestMethod.POST, RequestMethod.GET })
	public String getinfo(MemberInfoVO infoVO, ModelMap modelMap) {
		boolean is;

		modelMap.addAttribute("name", infoVO.getName());
		modelMap.addAttribute("password", infoVO.getPassword());
		is = memberService.registerMember(infoVO);
		System.out.println(is);

		System.out.println("id=" + infoVO.getName());
		System.out.println("pw=" + infoVO.getPassword());
		return "home";
	}
}

/*
 * @RequestMapping(value = "/updatetest", method = RequestMethod.GET) public
 * String dbUpdateTest(Model model) { boolean is = false; is =
 * memberService.updateMember(model);
 * 
 * 
 * 
 * model.addAttribute("serverTime", is); return "signupform"; }
 * 
 * 
 * @RequestMapping(value = "/dbtest", method = RequestMethod.GET) public String
 * dbConnectionTest(Model model) {
 * 
 * boolean is = false; is = memberService.registerMember();
 * 
 * model.addAttribute("serverTime", is); return "home"; }
 * 
 * 
 * @RequestMapping(value = "/tl", method = RequestMethod.GET) public String
 * home(Locale locale, Model model) {
 * logger.info("Welcome home! The client locale is {}.", locale);
 * 
 * Date date = new Date(); DateFormat dateFormat =
 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
 * 
 * String formattedDate = dateFormat.format(date);
 * 
 * model.addAttribute("serverTime", formattedDate );
 * 
 * //mysqlConnector.getConnection();
 * 
 * return "home"; }
 * 
 * 
 * >>>>>>> refs/remotes/origin/JMC_br } <<<<<<< HEAD /*
 * 
 * @RequestMapping(value = "/updatetest", method = RequestMethod.GET) public
 * String dbUpdateTest(Model model) { boolean is = false; is =
 * memberService.updateMember(model);
 * 
 * 
 * 
 * model.addAttribute("serverTime", is); return "signupform"; }
 * 
 * 
 * @RequestMapping(value = "/dbtest", method = RequestMethod.GET) public String
 * dbConnectionTest(Model model) {
 * 
 * boolean is = false; is = memberService.registerMember();
 * 
 * model.addAttribute("serverTime", is); return "home"; }
 * 
 * 
 * @RequestMapping(value = "/tl", method = RequestMethod.GET) public String
 * home(Locale locale, Model model) {
 * logger.info("Welcome home! The client locale is {}.", locale);
 * 
 * Date date = new Date(); DateFormat dateFormat =
 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
 * 
 * String formattedDate = dateFormat.format(date);
 * 
 * model.addAttribute("serverTime", formattedDate );
 * 
 * //mysqlConnector.getConnection();
 * 
 * return "home"; }
 * 
 * 
 * } ======= >>>>>>> refs/remotes/origin/JMC_br
 */