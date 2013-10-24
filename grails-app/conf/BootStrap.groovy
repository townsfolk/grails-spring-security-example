import com.example.Authority
import com.example.Team
import com.example.User
import com.example.oauth.AuthorizedGrantTypes
import com.example.oauth.OauthClient
import com.example.oauth.Scopes
import org.springframework.security.core.GrantedAuthority

class BootStrap {

	def init = { servletContext ->

		// load up a couple authorities
		Authority roleUser = Authority.findByAuthority("ROLE_USER") ?: new Authority(authority: "ROLE_USER").save(failOnError: true)
		Authority roleAdmin = Authority.findByAuthority("ROLE_ADMIN") ?: new Authority(authority: "ROLE_ADMIN").save(failOnError: true)
		Authority roleClient = Authority.findByAuthority("ROLE_CLIENT") ?: new Authority(authority: "ROLE_CLIENT").save(failOnError: true)

		// load up a couple test users
		User user1 = User.findByPhoneNumber("18885551234") ?: new User(phoneNumber: "18885551234", password: "password").save(failOnError: true)
		if (!user1.authorities) {
			user1.addToAuthorities(grantedAuthority: roleUser)
		}
		User user2 = User.findByPhoneNumber("18885555678") ?: new User(phoneNumber: "18885555678", password: "password").save(failOnError: true)
		if(!user2.authorities) {
			user2.addToAuthorities(grantedAuthority: roleAdmin)
		}

		Team team = Team.findById(1) ?: new Team(name: "Team #1").save(failOnError: true)
		if(!team.members) {
			team.addToMembers(user: user1)
		}

		OauthClient iphoneClient = OauthClient.findByClientId("iphone") ?: new OauthClient(
				clientId: "iphone", secretRequired: true, clientSecret: "iphone",
				scoped: true, scopes: Scopes.values(),
				authorizedGrants: AuthorizedGrantTypes.values()
		).save(failOnError: true)
		if(!iphoneClient.authorities) {
			iphoneClient.addToAuthorities(grantedAuthority: roleClient)
		}
	}

	def destroy = {
	}
}
