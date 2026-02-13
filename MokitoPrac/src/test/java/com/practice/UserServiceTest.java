package com.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class UserServiceTest {
//	@Test
//	public void getTypeOfUser() {
//		UserDao dao = new UserDao();
//		UserService userService = new UserService(dao);
//		String actualRes = userService.typeOfUser(1);
//		assertEquals("premium user",actualRes);
//	}
	@Test
	public void testDoubleAdd() {
		//Step 1: createFakeObject
		Cal calmock = mock(Cal.class);
		//Step 2: what mock object should return
		when(calmock.add(10, 2)).thenReturn(24);
		//Step 3: give the fake object reference 
		MathService service  = new MathService(calmock);
		int res = service.doubleAdd(10,2);
		
		assertEquals(24, res);
		
	}

}
