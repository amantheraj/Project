package com.aman.mail.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.aman.mail.model.MailInfo;
import com.aman.mail.model.UserInfo;



public interface MyService {
	public boolean register(UserInfo dto);
	public UserInfo login(String email,String password);
	public List<MailInfo> inbox();
	public List<MailInfo> message(HttpServletRequest request);
	public List<MailInfo> message1(HttpServletRequest request);
	public List<MailInfo> sent();
	public List<MailInfo> draft();
	public UserInfo compose(String from,String to,String sub,String body);
	public boolean forgot(String email,String password,String seqanswer,String cpassword);
	public boolean change(String password,String cpassword);
	public boolean delete(int id);
	public boolean finalDelete(int id);
	public List<MailInfo> deletedMail();
	public MailInfo message2(int id,MailInfo dto);
	public UserInfo composeEmailDraft(String from,String to,String sub,String body);
}
