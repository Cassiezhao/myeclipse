package chirs.listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import url.myurl;

import chris.pojo.User;
/**
 * 
 * @author chris
 *	监听session销毁的类以及session创建的类
 */
public class SessionListener implements HttpSessionListener {
	 public void sessionCreated(HttpSessionEvent arg0) {
	 }
	 public void sessionDestroyed(HttpSessionEvent event) {
		 
	 }
	}
