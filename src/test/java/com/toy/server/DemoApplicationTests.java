package com.toy.server;

import com.toy.server.dao.ctrade.UserReposity;
import com.toy.server.dao.jsf.JsfUserReposity;
import com.toy.server.entity.ctrade.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private UserReposity userReposity;

	@Autowired
	private JsfUserReposity jsfUserReposity;

	@Test
	public void contextLoads() {
		List<User> users = userReposity.findAll();
		for (User user: users) {
			System.out.println(user.toString());
		}
	}

	@Test
	public void testOne() {
		com.toy.server.entity.jsf.User user = new com.toy.server.entity.jsf.User();
		user.setName("加二十分");
		user.setPassword("456456");
		user.setAge(10);
		jsfUserReposity.save(user);
	}

}
