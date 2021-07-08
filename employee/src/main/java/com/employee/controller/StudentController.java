package com.employee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.employee.bean.StudentMarkBean;
@RestController
public class StudentController {

	
	Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	StudentMarkBean studentMarkBean;

	
	@RequestMapping("/welcome")
	public String getMessage() {// Spring MVC operation can be done easily here // outside of main.
		
		/*
		 * System.out.
		 * println("-------------------------SYSOUT from student controller-------------------------------------"
		 * ); logger.trace("TRACE LOGGER from STUDENT CONTROLLER");
		 * logger.debug("DEBUG LOGGER from STUDENT CONTROLLER");
		 * logger.info("INFO LOGGER from STUDENT CONTROLLER");
		 * logger.warn("WARN LOGGER from STUDENT CONTROLLER");
		 * logger.error("ERROR LOGGER from STUDENT CONTROLLER");
		 */
		System.out.println("Into controller");
		
		return "Welcome to Boot";
	}
	
	@RequestMapping("/welcometoindex")
	public ModelAndView getMessage2() {
		
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping("/getStudent")
	public ModelAndView getStudent() {
		ModelAndView mv = new ModelAndView("student");

		return mv;
	}

	/*
	 * @RequestMapping(value = "/processStudentData" , method = RequestMethod.POST )
	 * public ModelAndView processStudentData(HttpServletRequest request,
	 * HttpServletResponse response) {
	 * 
	 * ModelAndView mv = new ModelAndView("student");
	 * 
	 * studentMarkBean.setTamil(request.getParameter("tamil"));
	 * studentMarkBean.setEnglish(request.getParameter("english"));
	 * studentMarkBean.setMaths(request.getParameter("maths"));
	 * studentMarkBean.setScience(request.getParameter("science"));
	 * studentMarkBean.setSocial(request.getParameter("social"));
	 * 
	 * 
	 * mv.addObject("studentMarkBean", studentMarkBean);
	 * 
	 * mv.addObject("tamilmark", request.getParameter("tamil"));
	 * mv.addObject("tamilmark", request.getParameter("tamil"));
	 * mv.addObject("tamilmark", request.getParameter("tamil"));
	 * 
	 * 
	 * return mv; }
	 */

	@RequestMapping(value = "/findTotal", method = RequestMethod.POST)
	public StudentMarkBean findTotal(@RequestBody StudentMarkBean studentMarkBean) {
		/*
		 * request.getHeaderNames();
		 * studentMarkBean.setTamil(request.getParameter("tamil"));
		 * studentMarkBean.setEnglish(request.getParameter("english"));
		 * studentMarkBean.setMaths(request.getParameter("maths"));
		 * studentMarkBean.setScience(request.getParameter("science"));
		 * studentMarkBean.setSocial(request.getParameter("social"));
		 */
		return studentMarkBean;
	}


}
