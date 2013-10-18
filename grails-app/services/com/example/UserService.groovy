package com.example

import grails.transaction.Transactional
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

@Transactional
class UserService implements UserDetailsService {
	@Override
	UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
		log.debug("Looking user by phone number: ${phoneNumber}")
		User user = User.findByPhoneNumber(phoneNumber)
		if (user) {
			log.debug("User found: ${user}, phone: ${user.phoneNumber}")
			return user
		} else {
			log.debug("User not found - phone: ${phoneNumber}")
			throw new UsernameNotFoundException("No user found with phone number: ${phoneNumber}")
		}
	}
}