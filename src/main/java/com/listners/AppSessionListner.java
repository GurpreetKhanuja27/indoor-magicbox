package com.listners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class AppSessionListner implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session created" + se.getSession().getId());
	}
	
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session destroyed " + se.getSession().getId());
	}
}

