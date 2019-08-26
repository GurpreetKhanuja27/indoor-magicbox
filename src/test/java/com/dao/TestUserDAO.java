/**
 * 
 */
package com.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bean.User;
import com.exceptions.DuplicateIdException;

/**
 * @author lavjeetk
 *
 */
public class TestUserDAO {

	@Test
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

}
