import org.springframework.security.access.AccessDeniedException
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException

class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?(.${format})?" {
			constraints {
				// apply constraints here
			}
		}

		"/"(view: "/index")

		// for oauth support
		"/oauth/confirm.dispatch"(controller:"OAuth", action:"confirm_access")
		"/oauth/authorize" (uri:"/oauth/authorize.dispatch")
		"/oauth/token" (uri:"/oauth/token.dispatch")

		// error handling
		"403"(controller: "errors", action: 'unauthorized')
		"500"(view: '/error')
		"500"(controller: "errors", action: "unauthorized", exception: AccessDeniedException)
		"500"(controller: "errors", action: "unknownuser", exception: InvalidGrantException)
	}
}
