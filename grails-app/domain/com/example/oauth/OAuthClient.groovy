package com.example.oauth

import org.springframework.security.oauth2.provider.ClientDetails

import java.util.concurrent.TimeUnit

class OauthClient implements ClientDetails {

	String clientId
	boolean secretRequired
	String clientSecret
	boolean scoped
	Set<String> resourceIds
	Set<Scopes> scopes
	Set<AuthorizedGrantTypes> authorizedGrants
	Set<String> registeredRedirectUri
	Integer accessTokenValiditySeconds = TimeUnit.DAYS.toSeconds(30) // 30 days
	Integer refreshTokenValiditySeconds = TimeUnit.DAYS.toSeconds(365) // 1 year

	static constraints = {
		id(maxSize: 36)
	}

	static hasMany = [
			resourceIds: String,
			scopes: Scopes,
			authorizedGrants: AuthorizedGrantTypes,
			registeredRedirectUri: String,
			authorities: OauthClientAuthority
	]

	static mapping = {
		authorities(lazy: false)
		resourceIds(lazy: false)
		scopes(lazy: false)
		authorizedGrants(lazy: false)
		registeredRedirectUri(lazy: false)
	}

	@Override
	Set<String> getScope() { scopes*.toString() }

	@Override
	Set<String> getAuthorizedGrantTypes() { authorizedGrants*.toString() }

	Map<String, Object> getAdditionalInformation() { [:] }
}
