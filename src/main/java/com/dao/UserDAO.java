package com.dao;

import com.bean.Credentials;
import com.bean.User;
import com.exceptions.DuplicateIdException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class UserDAO {

	static Connection conn = null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LoginDb", "root", "root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}
	
    public int registerUser(Credentials credentials) {

        String query = "insert into loign(username, password) values (?, ?)";
        try {
            
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            {
                preparedStatement.setString(1, credentials.getUserName());
                preparedStatement.setString(2, credentials.getPassword());

                int row = preparedStatement.executeUpdate();

                return row;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return 00;
    }

    public int registerStudent(User registerUser) throws DuplicateIdException{

        String query = "insert into StudentRegistration (UniversityNumber, StuName, Sex) \n" +
                "values( ?, ?, ?)";
		int count  = 0;
        try {
                
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setInt(1, registerUser.getUniversityNumber());
            preparedStatement.setString(2, registerUser.getStudentName());
            preparedStatement.setString(3, registerUser.getSex());
            count = preparedStatement.executeUpdate();
           

        } catch (SQLException e) {
            //logging : log the root cause
        	throw new DuplicateIdException("Id" + registerUser.getUniversityNumber() + " is duplicate !!");
        }
        return count;
    }


    public List<User> registeredStudentList(){
        String query = "select * from studentRegistration";

       List<User> regList = new LinkedList<>();
        try{
         
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet registeredStudentList = preparedStatement.executeQuery();
             while (registeredStudentList.next()){

                 int universityNumber = registeredStudentList.getInt("universityNumber");
                 String studentName = registeredStudentList.getString("stuName");
                 String sex = registeredStudentList.getString("sex");

                 User registerUser = new User(universityNumber, studentName, sex);
                 regList.add(registerUser);

             }

        }  catch (SQLException e) {
            e.printStackTrace();
        }

        return regList;
    }
    
    public void updateStudent(User user) {
    	String query = "update studentRegistration set stuName = abc";
    }
}
