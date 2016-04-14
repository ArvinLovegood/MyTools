package com.wzl.sys.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.kit.PropKit;

public class LoginInterceptor implements Interceptor {

	private static String  view_front_path=PropKit.get("view_front");
	private static String  view_admin_path=PropKit.get("view_admin");
	private static String  view_mobile_path=PropKit.get("view_mobile");
	
	@Override
	public void intercept(Invocation inv) {
		if(inv.getActionKey().startsWith(view_admin_path)){
			 Object isLogin =inv.getController().getSession().getAttribute(inv.getController().getSession().getId()+"_islogin");
			 System.out.println(">>>>>>>>>>>>>是否登陆>>>>>>>>>>>>>>>>："+("1".equals(isLogin)?"是":"否"));
			 if(isLogin!=null&&"1".equals(isLogin)){//已经登录
				 inv.invoke();
			 }else{
				 System.out.println(">>>>>>>>>>>>>未登录跳转到登录页面>>>>>>>>>>>>>>>>");
				 inv.getController().redirect("/");
			 }
		}else{
			 inv.invoke();
		}
	}

}
