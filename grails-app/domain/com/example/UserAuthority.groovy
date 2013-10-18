package com.example

import org.springframework.security.core.GrantedAuthority

class UserAuthority implements GrantedAuthority {

	Authority grantedAuthority

	static belongsTo = [user: User]

	static constraints = {
		grantedAuthority(blank: false, nullable: false)
	}

	static mapping = {
		id(composite: ['user', 'grantedAuthority'])
		version(false)
	}

	String getAuthority() {
		return grantedAuthority.authority
	}
}
