package com.example.oauth

class OauthRefreshToken {

	String id
	byte[] token
	byte[] authentication

	static constraints = {
		// everything is (nullable: false) by default
		token(maxSize: 1024) // 1k
		authentication(maxSize: 1024 * 10) // 10k
	}

	static mapping = {
		id(generator: 'assigned', column: 'token_id')
		version(false)
	}
}
