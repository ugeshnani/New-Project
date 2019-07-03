package com.demo.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dao.fileUpload;
import com.demo.dao.loginRepo;
import com.demo.dao.signupRepo;
import com.demo.model.login;
import com.demo.model.signup;

@Controller

public class controller {
	/*
	 * @Autowired private loginRepo lr;
	 */
	
	@Autowired
	private fileUpload fu;

	
	@RequestMapping("/")
	public ModelAndView home() throws ClassNotFoundException, SQLException
	{
		ModelAndView mv = new ModelAndView();
		System.out.println("inside /");
		mv.setViewName("fileUpoad.jsp");
		Object ob =fu.getData();
		mv.addObject(ob);
		System.out.println(ob);
		
		return mv;
	}
	@RequestMapping("/align")
	public String align()
	{
		System.out.println("Inside /align");
		return "home.jsp";
	}
/*
 * spring.h2.console.enabled=true
spring.datasource.platform=h2
spring.datasource.url=  jdbc:h2:~/test
debug=false
 * @RequestMapping(value="/signup",method=RequestMethod.POST) public
 * ModelAndView signup(signup sup) { ModelAndView mv = new ModelAndView();
 * System.out.println("inside sighup"); System.out.println(sup);
 * mv.setViewName("signup.jsp"); su.save(sup); return mv; }
 * 
 * @RequestMapping(value="/GetAllDetails",method=RequestMethod.GET)
 * 
 * @ResponseBody public String GetAllDetails() { ModelAndView mv = new
 * ModelAndView(); System.out.println("inside GetAllDetails"); return
 * su.findAll().toString(); }
 * 
 * @RequestMapping(value="/Details/{employeeid}", method=RequestMethod.GET)
 * 
 * @ResponseBody public String Details(@PathVariable int employeeid) {
 * ModelAndView mv = new ModelAndView(); System.out.println("inside login");
 * System.out.println(employeeid); return su.findById(employeeid).toString(); }
 * }
 * 
 */
}