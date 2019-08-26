package com.controller;

import com.bean.Credentials;
import com.bean.User;
import com.dao.UserDAO;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet("/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    UserDAO loginDao = new UserDAO();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

       /* String userName =  request.getParameter("uname");
        String  password = request.getParameter("password");
        Credentials credentials = new Credentials(userName, password);
        int regStatus   =  loginDao.registerUser(credentials);
        if(regStatus ==00){
            RequestDispatcher view = request.getRequestDispatcher("login.jsp");
            view.forward(request,response);
        }else{
            RequestDispatcher view = request.getRequestDispatcher("home.jsp");
            view.forward(request,response);
        }*/

       //parsing the values from the registration.jsp page
        int universityNumber = Integer.parseInt(request.getParameter("universityNumber"));
        String studentName = request.getParameter("studentName");
        String sex = request.getParameter("sex");

        PrintWriter out = response.getWriter();
        //passing the values to the registerUser class
      /*  User registerUser = new User(universityNumber, studentName, sex);
        boolean regStuStatus = loginDao.registerStudent(registerUser);
        if(!regStuStatus){
            RequestDispatcher view = request.getRequestDispatcher("home.jsp");
            view.forward(request,response);
        }else{
            RequestDispatcher view = request.getRequestDispatcher("registration.jsp");
            view.forward(request,response);
        }*/

       System.out.println(loginDao.registeredStudentList());


    }
}
