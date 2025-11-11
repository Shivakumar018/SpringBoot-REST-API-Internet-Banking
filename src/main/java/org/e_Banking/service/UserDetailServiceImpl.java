package org.e_Banking.service;


import org.e_Banking.entity.User;
import org.e_Banking.exceptionHandling.DataNotFoundException;
import org.e_Banking.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new DataNotFoundException("Invalid Email");
		} else {
			return new UserDetailsImpl(user);
		}
	}

}
