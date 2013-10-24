package com.example.oauth

class OauthAccessToken {

	String id
	byte[] token
	String authenticationId
	String userName
	String clientId
	byte[] authentication
	String refreshToken

	static constraints = {
		token(maxSize: 1024) // 1k
		authentication(maxSize: 1024 * 10) // 10k
	}

	static mapping = {
		id(generator: 'assigned', column: 'token_id')
		version(false)
	}
}
