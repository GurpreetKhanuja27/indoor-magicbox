package com.listners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListner implements ServletContextListener, ServletContextAttributeListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Context initialized");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Context destroyed");

	}

	public void attributeAdded(ServletContextAttributeEvent event) {
		
		System.out.println(event.getName() + " " + event.getValue());
		System.out.println("Value " + event.getServletContext().getAttribute("userdata"));
	}

	public void attributeRemoved(ServletContextAttributeEvent event) {
	}

	public void attributeReplaced(ServletContextAttributeEvent event) {
	}
}
