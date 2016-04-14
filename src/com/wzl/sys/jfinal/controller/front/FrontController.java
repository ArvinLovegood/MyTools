package com.wzl.sys.jfinal.controller.front;

import com.wzl.sys.jfinal.controller.baseController;

public class FrontController extends baseController{
	public void index(){
		renderJsp("index.jsp");
	}
}
