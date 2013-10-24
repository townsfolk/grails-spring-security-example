package com.example.oauth

import com.example.Authority
import org.springframework.security.core.GrantedAuthority

class OauthClientAuthority implements GrantedAuthority {
	Authority grantedAuthority

	static belongsTo = [client: OauthClient]

	static constraints = {
		grantedAuthority(blank: false, nullable: false)
	}

	static mapping = {
		id(composite: ['client', 'grantedAuthority'])
		version(false)
	}

	String getAuthority() {
		return grantedAuthority.authority
	}
}
