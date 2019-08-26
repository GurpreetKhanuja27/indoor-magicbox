package com.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/UniversityController")
public class MyFilter implements Filter{  
	  
public void init(FilterConfig arg0) throws ServletException {}  
      
public void doFilter(ServletRequest req, ServletResponse resp,  
    FilterChain chain) throws IOException, ServletException {  
          
    PrintWriter out=resp.getWriter();  
    System.out.println("filter is invoked before");  
    
    //// request 
    
    HttpServletRequest request = (HttpServletRequest)req;
    System.out.println(request.getLocalPort());
    System.out.println(request.getPathInfo());
    System.out.println(request.getLocalAddr());
    //ip address , LOCALE
    //security : authentication 
    
          
    chain.doFilter(req, resp);//sends request to next resource  
          
    System.out.println("filter is invoked after");  
    
    // change response type
    // compress the response
    //...
    
    }  
    public void destroy() {}  
}  