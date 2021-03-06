package com.aman.mail.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;

import com.aman.mail.model.MailInfo;
import com.aman.mail.model.UserInfo;



public interface MyDAO {
	public boolean register(UserInfo dto);
	public UserInfo login(String email,String password);
	public List<MailInfo> inbox();
	public List<MailInfo> message(HttpServletRequest request);
	public List<MailInfo> message1(HttpServletRequest request);
	public List<MailInfo> sent();
	public List<MailInfo> draft();
	public UserInfo compose(String from,String to,String sub,String body);
	public UserInfo composeEmailDraft(String from,String to,String sub,String body);
	public boolean forgot(String email,String password,String seqanswer,String cpassword);
	public boolean change(String password,String cpassword);
	public boolean delete(int id);
	public boolean finalDelete(int id);
	public List<MailInfo> deletedMail();
	public MailInfo message2(int id,MailInfo dto);
	
}
