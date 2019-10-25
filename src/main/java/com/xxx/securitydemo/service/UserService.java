package com.xxx.securitydemo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xxx.securitydemo.dao.UserDao;
import com.xxx.securitydemo.domain.User;
@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	public User findById(Integer id) {
		return userDao.findById(id).orElse(null);
	}
	
	public User save(User user) {
		return userDao.save(user);
	}
	
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
}
