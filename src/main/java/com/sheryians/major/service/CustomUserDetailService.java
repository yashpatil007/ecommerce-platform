package com.sheryians.major.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sheryians.major.model.CustomUserDetail;
import com.sheryians.major.model.User;
import com.sheryians.major.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findUserByEmail(username);
		user.orElseThrow(()-> new UsernameNotFoundException("user not found"));
		return user.map(CustomUserDetail :: new).get();
	}
	

}
