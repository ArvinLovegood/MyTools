package com.wzl.sys.jfinal.controller;

import com.jfinal.core.Controller;

public class baseController extends Controller{
	
	
	public void login(){
		renderJsp("login.jsp");
	}
	
	public void doLogin(){
		getSession().setAttribute(getSession().getId()+"_islogin", "1");
		redirect("/a");
	}
	
	public void loginOut(){
		getSession().setAttribute(getSession().getId()+"_islogin", "0");
		redirect("/f");
	}
}
