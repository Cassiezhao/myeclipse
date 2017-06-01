package chris.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chris.pojo.User;

public class myfilter  extends HttpServlet implements Filter{
	/**
	 * 拦截器操作，保证用户登陆
	 */
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;  
        HttpServletResponse response = (HttpServletResponse) resp;  
        HttpSession session = request.getSession(true);
        String url = request.getRequestURI();
        User u=(User) session.getAttribute("nuser");
        String location="login.jsp";
    	//System.out.println(request.getServletPath());
    	String path = request.getContextPath(); 
    	String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path; 
    	/**
    	 * 重定向的经典解决方法
    	 */
        if(u==null){
        	//System.out.println(url);
        	 // request.getRequestDispatcher("../login.jsp").forward(request, response);
        	if(url.endsWith("/zhihui/") || request.getServletPath().endsWith("login.jsp")){
        		chain.doFilter(request, response);  
        		return;
        	}
        	//response.sendRedirect("http://localhost:8080/zhihui/login.jsp");
        	  System.out.println("成功拦截到外星人企图入侵网站后台   :  " + url);  
              response.setHeader("Cache-Control", "no-store");  
              response.setDateHeader("Expires", 0);  
              response.setHeader("Pragma", "no-cache");
              response.sendRedirect(basePath); 
        }else{
        	chain.doFilter(request, response);  
        }
	}	

	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
