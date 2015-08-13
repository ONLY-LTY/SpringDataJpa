package com.boxfish.web;


import com.boxfish.entity.UserEntity;
import com.boxfish.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class IndexController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value={" ", "/", "/index"})
	public UserEntity index(HttpSession session){
		UserEntity user = userRepository.findOne(2L);
		session.setAttribute("info",user);
		return user;
	}
}
