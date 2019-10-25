package com.xxx.securitydemo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.xxx.securitydemo.domain.User;
public interface UserDao extends JpaRepository<User,Integer>{
	User findByUsername(String userName);
}
