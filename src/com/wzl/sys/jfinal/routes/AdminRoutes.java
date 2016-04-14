package com.wzl.sys.jfinal.routes;

import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.wzl.sys.jfinal.controller.admin.AdminController;
import com.wzl.sys.jfinal.controller.front.FrontController;

public class AdminRoutes extends Routes {

	@Override
	public void config() {
		add(PropKit.get("view_admin"), AdminController.class);
	}

}
