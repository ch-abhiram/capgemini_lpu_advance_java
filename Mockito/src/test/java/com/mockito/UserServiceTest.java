package com.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	@Mock
	UserDao daomock;
	@InjectMocks
	UserService service;
	@Test
	public void typeOfUser() {
//		UserDao daomock = mock(UserDao.class);
		
		User fakeObj = new User();
		fakeObj.setId(101);
		fakeObj.setName("allen");
		fakeObj.setBalance(2000);
		
		when(daomock.findById(101)).thenReturn(fakeObj);
		
//		UserService service = new UserService(daomock);
		
		String actualRes = service.typeOfUser(101);
		
		assertEquals("regular User", actualRes);
	}

}
