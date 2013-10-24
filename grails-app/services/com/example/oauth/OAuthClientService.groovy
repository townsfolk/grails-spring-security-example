package com.example.oauth

import grails.transaction.Transactional
import org.springframework.security.oauth2.provider.ClientDetails
import org.springframework.security.oauth2.provider.ClientDetailsService
import org.springframework.security.oauth2.provider.ClientRegistrationException

@Transactional
class OauthClientService implements ClientDetailsService {

	@Override
	ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		OauthClient.findByClientId(clientId)
	}
}
