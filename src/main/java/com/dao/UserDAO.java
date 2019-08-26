package com.dao;

import com.bean.Credentials;
import com.bean.User;
import com.exceptions.DuplicateIdException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class UserDAO {

    public int registerUser(Credentials credentials) {

        String query = "insert into loign(username, password) values (?, ?)";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LoginDb", "root", "root");
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            {
                preparedStatement.setString(1, credentials.getUserName());
                preparedStatement.setString(2, credentials.getPassword());

                int row = preparedStatement.executeUpdate();

                return row;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return 00;
    }

    public boolean registerStudent(User registerUser) throws DuplicateIdException{

        String query = "insert into StudentRegistration (UniversityNumber, StuName, Sex) \n" +
                "values( ?, ?, ?)";
		boolean regStuStatus  = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LoginDb", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, registerUser.getUniversityNumber());
            preparedStatement.setString(2, registerUser.getStudentName());
            preparedStatement.setString(3, registerUser.getSex());
            regStuStatus = preparedStatement.execute();
           

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            //logging : log the root cause
        	throw new DuplicateIdException("Id" + registerUser.getUniversityNumber() + " is duplicate !!");
        }
        return regStuStatus;
    }


    public List<User> registeredStudentList(){
        String query = "select * from studentRegistration";

       List<User> regList = new LinkedList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LoginDb", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet registeredStudentList = preparedStatement.executeQuery();
             while (registeredStudentList.next()){

                 int universityNumber = registeredStudentList.getInt("universityNumber");
                 String studentName = registeredStudentList.getString("stuName");
                 String sex = registeredStudentList.getString("sex");

                 User registerUser = new User(universityNumber, studentName, sex);
                 regList.add(registerUser);

             }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return regList;
    }
}
