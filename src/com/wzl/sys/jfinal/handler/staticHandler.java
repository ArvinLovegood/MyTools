package com.wzl.sys.jfinal.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;
import com.jfinal.kit.PropKit;

public class staticHandler extends Handler {

	@Override
	public void handle(String handle, HttpServletRequest request, HttpServletResponse Response, boolean[] arg3) {
		// TODO Auto-generated method stub
		
		System.out.println(handle);
		if(handle.startsWith(PropKit.get("view_base"))){
			try {
				Response.setContentType("text/html; charset=utf-8"); 
				Response.setCharacterEncoding("utf-8");
				PrintWriter wr = Response.getWriter();
				wr.write("没有权限！");
				wr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}	
			
			nextHandler.handle(handle, request, Response, arg3);
		
		
	}

}
