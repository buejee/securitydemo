package com.xxx.securitydemo;
import static org.junit.Assert.assertEquals;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import com.xxx.securitydemo.domain.User;
import com.xxx.securitydemo.service.UserService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	public void insert() {
		User user = new User();
		user.setUsername("hadoop");
		String password = passwordEncoder.encode("hadoop");
		user.setPassword(password);
		user.setAge(18);
		user.setMobile("15011186301");
		user.setCreateDate(new Date());
		user.setModifyDate(new Date());
		User result = userService.save(user);
		assertEquals(result.getPassword(), password);
	}
	
	@Test
	public void update() {
		User user = userService.findById(1);
		user.setCreateDate(new Date());
		user.setModifyDate(new Date());
		int age = 20;
		user.setAge(age);
		User o = userService.save(user);
		assertEquals(o.getAge(), age);
	}
	
	@Test
	public void find() {
		User user = userService.findByUsername("admin");
		assertEquals(18, user.getAge());
	}
}
