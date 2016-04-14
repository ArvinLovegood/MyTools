package com.wzl.sys.jfinal.routes;

import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.wzl.sys.jfinal.controller.admin.AdminController;
import com.wzl.sys.jfinal.controller.app.AppController;

public class AppRoutes extends Routes {

	@Override
	public void config() {
		add(PropKit.get("view_mobile"), AppController.class,PropKit.get("view_base")+PropKit.get("view_mobile"));

	}

}
