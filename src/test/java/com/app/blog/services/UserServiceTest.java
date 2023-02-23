package com.app.blog.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.*;

import com.app.blog.entities.User;
import com.app.blog.repositories.UserRepo;

@SpringBootTest
class UserServiceTest {

	@InjectMocks
	private UserServiceImpl userServiceImpl;

	@Mock
	private UserRepo userRepo;

	@Test
	void testCreateUser() {
		User u = new User();
		u.setUsername("nats");
		userServiceImpl.createUser(u);
		System.out.println(u);

//		Mockito.when(userRepo.save(u)).thenReturn(u);

		assertNotNull(u);
		assertEquals("nats", u.getUsername());

//		assertEquals(u, null);
	}
}
