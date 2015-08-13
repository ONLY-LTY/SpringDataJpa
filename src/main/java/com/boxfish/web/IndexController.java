package com.boxfish.web;


import com.boxfish.entity.UserEntity;
import com.boxfish.repository.UserCustomRepository;
import com.boxfish.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class IndexController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserCustomRepository userCustomRepository;

	@RequestMapping(value={" ", "/", "/index"})
	public List index(HttpSession session){
		List<UserEntity> user = userRepository.findByUserName("LTY");
		session.setAttribute("info",user);
		return user;
	}
	@RequestMapping(value = "/get")
	public List getByUserName(){
		return userCustomRepository.findByUserName("LTY");
	}
	@RequestMapping(value = "/getId")
	public UserEntity getById(){
		return userCustomRepository.findById(2L);
	}
	@RequestMapping(value = "add")
	public String add(){
		UserEntity user = new UserEntity();
		user.setPassword("liitngyang-0529");
		user.setUserName("LTY");
		user.setTel("12345678");
		try {
			userCustomRepository.save(user);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}

	}

}
