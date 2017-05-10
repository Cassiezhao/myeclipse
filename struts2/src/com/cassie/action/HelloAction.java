package com.cassie.action;



public class HelloAction {
/*   1.每次访问servlet时，执行service方法。
 * 		写类继承HttpServlet，重写类里的方法。
 * 		在web.xml中配置中配置servlet访问路径 
 * 
 * 	 2.访问action，每次访问action时，默认执行名字为execute方法。
 *		配置action路径	 
 *	 3.配置action类访问路径
 *		（1）创建Struts2核心配置文件
 *			核心配置文件 ：名称位置是固定的
 *			位置必须在src下，名称struts.xml
 *		（2）引入dtd约束
 *		（3）action配置
 *	 4.配置Struts2过滤器		
 */
	
	public String execute(){
		return  "ok";
	}
}
