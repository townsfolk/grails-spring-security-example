package com.example.oauth

import org.springframework.security.oauth2.provider.ClientDetails

class OAuthClient implements ClientDetails {

	String id
	String name
	boolean secretRequired
	String clientSecret
	boolean scoped
	Set<String> resourceIds
	Set<Scopes> scope
	Set<AuthorizedGrantTypes> authorizedGrantTypes
	Set<String> registeredRedirectUri
	Integer accessTokenValiditySeconds
	Integer refreshTokenValiditySeconds

	static constraints = {
		id(maxSize: 36)
	}

	static hasMany = [
			resourceIds: String,
			scope: Scopes,
			authorizedGrantTypes: AuthorizedGrantTypes,
			registeredRedirectUri: String,
			authorities: OAuthClientAuthority
	]

	static mapping = {
		id(generator: 'uuid2')
	}

	String getClientId() {
		return id
	}

	Map<String, Object> getAdditionalInformation() {
		[name: name]
	}


}
