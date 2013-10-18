package com.example

import org.springframework.security.core.userdetails.UserDetails

class User implements UserDetails {

	String phoneNumber
	String password
	boolean accountExpired
	boolean accountLocked
	boolean enabled = true
	boolean passwordExpired

	static constraints = {
		phoneNumber(blank: false, nullable: false, unique: true, validator: { _phone, _user ->
			_phone ==~ /\d+/ ?: 'invalid' // must be all digits
		})
		password(blank: false, nullable: false)
	}

	static hasMany = [authorities: UserAuthority, memberships: TeamMember]

	static mapping = {
		authorities(lazy: false)
	}

	@Override
	String getUsername() {
		return phoneNumber
	}

	@Override
	boolean isAccountNonExpired() {
		return !accountExpired
	}

	@Override
	boolean isAccountNonLocked() {
		return !accountLocked
	}

	@Override
	boolean isCredentialsNonExpired() {
		return !passwordExpired
	}

	@Override
	boolean isEnabled() {
		return enabled
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	private void encodePassword() {
		// do nothing for now
	}
}
