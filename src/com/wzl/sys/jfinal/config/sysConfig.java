/**  
 * @Title: AppRequestConfig.java
 * @Package com.insigma.bjtf.app.config
 * @Description: TODO
 * @author spark
 * @date 2015年11月10日
 */
package com.wzl.sys.jfinal.config;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.UrlSkipHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.render.ViewType;
import com.wzl.sys.jfinal.controller.baseController;
import com.wzl.sys.jfinal.handler.staticHandler;
import com.wzl.sys.jfinal.interceptor.LoginInterceptor;
import com.wzl.sys.jfinal.routes.AdminRoutes;
import com.wzl.sys.jfinal.routes.AppRoutes;
import com.wzl.sys.jfinal.routes.FrontRoutes;


/**
 * @author Spark
 * jfinal插件启动的主配置类
 */
public class sysConfig extends JFinalConfig {
	
	/* 
	 * jfinal启动后将调用此方法
	 */
	
	public void afterJFinalStart() {
		super.afterJFinalStart();
		System.out.println("------my-------jinal启动成功！---------------");
	}
	
	/* 
	 *jfinal停止前将调用此方法
	 */
	
	public void beforeJFinalStop() {
		super.beforeJFinalStop();
	}

	/* 
	 * jfinal常量配置
	 */
	
	public void configConstant(Constants me) {
		//加载配置文件
		PropKit.use("config.properties");
		
		me.setDevMode(PropKit.getBoolean("DevMode"));
		me.setViewType(ViewType.JSP);
		me.setError404View("404.jsp");
	}

	/* jfinal路由配置
	 * 前台不需要登陆的功能请以  /f  开头，后台需要登录的请以  /a  开头
	 */
	
	public void configRoute(Routes me) {
		
		me.add("/",baseController.class);
		
		//前台路由配置
		me.add(new FrontRoutes());
		
		//后台路由配置
		me.add(new AdminRoutes());
				
		//移动段app发的请求路由配置
		me.add(new AppRoutes());
	}

	/* jfinal插件配置
	 * 主要用来配置数据源，实体-数据库表映射关系 和缓存配置等
	 */
	
	public void configPlugin(Plugins me) {
		String dbType=PropKit.get("db.type"); 
		String url=PropKit.get(dbType+".jdbcUrl");
		String username=PropKit.get(dbType+".userName");
		String password=PropKit.get(dbType+".passWord");
		DruidPlugin druidPlugin = new DruidPlugin(url, username, password);
		ActiveRecordPlugin arp= new ActiveRecordPlugin("mainDb", druidPlugin);
		me.add(druidPlugin);
		me.add(arp);	

		me.add(new  EhCachePlugin());//ehcache缓存插件  具体配置见 ehcache.xml
				
/*				try {
					//利用redis数据库，统计jfinal每个action的请求次数，IP,User-Agent次数
					me.add(new RedisPlugin("request", PropKit.get("redis.host"),PropKit.getInt("redis.port", 6379), PropKit.get("redis.auth")));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			 

				
				

	}

	/* jfinal全局拦截器，此拦截器将拦截所有jfinal处理的请求路由
	 * 
	 */
	
	public void configInterceptor(Interceptors me) {		

		me.addGlobalActionInterceptor(new LoginInterceptor());

	}

	/* jfinal全局处理器，功能类似 jfinal全局拦截器，在 全局拦截器之前执行。
	 * 
	 */
	
	public void configHandler(Handlers me) {
		
		//非静态资源拦截,不允许直接访问view文件夹下的文件
		me.add(new staticHandler());
		

	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] BASE64 = Base64.encodeBase64("wzl_spark_2016".getBytes("UTF-8"));
		System.out.println(new String(BASE64,"UTF-8"));
	}
}
