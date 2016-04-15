package com.wzl.sys.jfinal.routes;

import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.wzl.sys.jfinal.controller.front.FrontController;

public class FrontRoutes extends Routes {

	@Override
	public void config() {
		add(PropKit.get("view_front"), FrontController.class,PropKit.get("view_base")+PropKit.get("view_front"));

	}

}