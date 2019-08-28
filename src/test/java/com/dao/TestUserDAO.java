/**
 * 
 */
package com.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.bean.User;
import com.exceptions.DuplicateIdException;

/**
 * @author lavjeetk
 *
 */
public class TestUserDAO {

	@Test
	@Ignore
	public void testRegisterStudent() {
		
		UserDAO dao = new UserDAO();
		User u = new User(52,"Ayush","MALE");
		int count = 0;
		try {
			count = dao.registerStudent(u);
			System.out.println(count);
		} catch (DuplicateIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(1,count);
		
	}
	
	@Test
	public void testRegisteredStudentList() {
		UserDAO dao = new UserDAO();
		List<User> users = dao.registeredStudentList();
		assertEquals(4,users.size());
	
	
	}	
	
	@Test
	public void testUser() {
		
	}

}
