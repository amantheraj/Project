package com.aman.mail.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aman.mail.model.MailInfo;
import com.aman.mail.model.UserInfo;
import com.aman.mail.service.MyService;


@RequestMapping("/")
@Component
public class MyController {
	@Autowired
	MyService ms;
	
	@Autowired 
	HttpSession session;
	 
	
	@RequestMapping("/reg")
	public String m1() {
		return "register";
	}
	@RequestMapping("/log")
	public String m2() {
		return "login";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView register(@ModelAttribute UserInfo dto) {
		boolean b=ms.register(dto);
		if(b) {
		return new ModelAndView("login","m","<h3>Registration successfull</h3>");
		}else {
			return new ModelAndView("register","m","Registration Failed");
		}
	}
	
	  @RequestMapping(value="/login",method=RequestMethod.POST) 
	  public ModelAndView login(@RequestParam String email,String password) { 
		  UserInfo sdto=ms.login(email, password); 
		  if(sdto!=null) {
	  session.setAttribute("email1", sdto.getEmail()); 
	  
	  return new ModelAndView("home","sdto",sdto); 
	  }else { 
		  return new ModelAndView("login","msg","Login Failed");
		  }
		  }
	  
	  @RequestMapping("/message") 
	  public ModelAndView message(HttpServletRequest request) {
		  
		  if(session.getAttribute("email1")!=null) {
		 List<MailInfo> list=ms.message(request);
		  return new ModelAndView("message","list",list);
		  }else {
			  return new ModelAndView("message","masg","Login First");
		  }
		  }
	  @RequestMapping("/message1") 
	  public ModelAndView message1(HttpServletRequest request) {
		  
		  if(session.getAttribute("email1")!=null) {
		 List<MailInfo> list=ms.message1(request);
		  return new ModelAndView("message1","list",list);
		  }else {
			  return new ModelAndView("message1","masg","Login First");
		  }
		  }
	  @RequestMapping("/composeDraft")
	  public ModelAndView composeDraft(@RequestParam int id,MailInfo dto) {
		  
		  MailInfo adto=ms.message2(id,dto);
	
		  if(adto!=null){
			  session.setAttribute("eid", adto.getId());
		  return new ModelAndView("composeDraft","adto",adto);
		  }else {
			  return new ModelAndView("home","msg","message not display");
		  }
	  }
	  @RequestMapping("/composedraftData") 
	  public ModelAndView composeEmailDraft(@RequestParam String to,String sub,String body) {
		  String from=(String) session.getAttribute("email1");
		  
		  UserInfo b=ms.composeEmailDraft(from,to,sub,body);
		 if(b!=null) {
		  return new ModelAndView("successpage","msg","Mail Sent Successfully"); 
		 }else {
			 return new ModelAndView("home","msg","Sending Failed,Save in Draft");
		 }
		 
	  }
	  @RequestMapping("/inbox") 
	  public ModelAndView inbox() {
		  if(session.getAttribute("email1")!=null) {
		 List<MailInfo> list=ms.inbox();
		  return new ModelAndView("inbox","list",list);
		  }else {
			  return new ModelAndView("login","masg","Login First");
		  }
		  }
	
	  @RequestMapping("/sent") 
	  public ModelAndView sent() {
		  if(session.getAttribute("email1")!=null) {
		 List<MailInfo> list=ms.sent();
		  return new ModelAndView("sent","list",list); 
		  }else {
			  return new ModelAndView("login","masg","Login First");
		  }
		  }
	  @RequestMapping("/draft")
		public ModelAndView draft() {
		  if(session.getAttribute("email1")!=null) {
		  List<MailInfo> list=ms.draft();
		  return new ModelAndView("draft","list",list);
	  }else {
		  return new ModelAndView("login","masg","Login First");
	  }
		}
	  @RequestMapping("/compose")
		public ModelAndView m5() {
		  if(session.getAttribute("email1")!=null) {
		  String email=(String) session.getAttribute("email1");
			return new ModelAndView("compose","msg",email);
		  }else {
			  return new ModelAndView("login","masg","Login First");
		  }
		}
	 
	  @RequestMapping("/comp") 
	  public ModelAndView compose(@RequestParam String to,String sub,String body) {
		  String from=(String) session.getAttribute("email1");
		  UserInfo b=ms.compose(from,to,sub,body);
		 if(b!=null) {
		  return new ModelAndView("successpage","msg","Mail Sent Successfully"); 
		 }else {
			 return new ModelAndView("home","msg","Sending Failed,Save in Draft");
		 }
		 
	  }
	  
	  @RequestMapping("/logout")
	  public ModelAndView logout() {
		  if(session.getAttribute("email1")!=null) {
		  session.invalidate();
		  return new ModelAndView("login","msg","Logout Success");
		  }else {
			  return new ModelAndView("login","msg","Login First");
		  }
	  }
	  @RequestMapping("/delete")
	  public ModelAndView delete(@RequestParam int id) {
		  
		  boolean b=ms.delete(id);
		  if(b) {
		  return new ModelAndView("home","msg","Deleted Successfully");
		  }else {
			  return new ModelAndView("home","msg","Delete Failed");
		  }
	  }
	 
	  @RequestMapping("/fpass")
	  public ModelAndView forgot() {
		  return new ModelAndView("forgot");
	  }
	  @RequestMapping(value="/forgot",method=RequestMethod.POST)
	  public ModelAndView forgot(@RequestParam String email,String password,String seqanswer,String cpassword) {
		  boolean b=ms.forgot(email, password, seqanswer, cpassword);
		  if(b) {
		  return new ModelAndView("login","msg","Password Changed Successfully");
		  }else {
			  return new ModelAndView("forgot","msg","<h3>Invalid Details or Wrong Password</h3>");
		  }
	  }
	  @RequestMapping("/change")
	  public ModelAndView change(HttpServletRequest req) {
		  session=req.getSession(false);
		String email=  (String) session.getAttribute("email1");
		if(email!=null) {
		  return new ModelAndView("change");
		}else {
		 return new ModelAndView("login","msg","Login First");
		}
	  }
	  @RequestMapping(value="/chang",method=RequestMethod.POST)
	  public ModelAndView change(@RequestParam String password,String cpassword) {
		  boolean b=ms.change( password,cpassword);
		  if(b) {
		  return new ModelAndView("home","msg","Password Changed Successfully");
		  }else {
			  return new ModelAndView("change","msg","Invalid Details or Worng Password");
		  }
	  }
	  @RequestMapping("/deleteMail")
	  public ModelAndView deleted() {
		  if(session.getAttribute("email1")!=null) {
		  List<MailInfo> list=ms.deletedMail();
		  return new ModelAndView("deletedMail","list",list);
	  }else {
		  return new ModelAndView("login","masg","Login First");
	  }
	}
	  @RequestMapping("/finalDelete")
	  public ModelAndView permanentDelete(@RequestParam int id) {
		  
		  boolean b=ms.finalDelete(id);
		  if(b) {
		  return new ModelAndView("home","msg","Mail Deleted Permanently");
		  }else {
			  return new ModelAndView("home","msg","Delete Failed");
		  }
	  }
	  
	 

}
