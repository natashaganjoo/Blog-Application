package com.app.blog.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void testConstructor() {
		User u = new User();
		assertNotNull(u, "");
	}

	@Test
	void testGetter() {
		User u = new User();
		assertEquals(null, u.getUsername());
	}

	@Test
	void testSetter() {
		User u = new User();
		u.setUsername("nats");
		assertEquals("nats", u.getUsername());
	}

}
