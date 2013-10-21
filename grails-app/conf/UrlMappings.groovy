import org.springframework.security.access.AccessDeniedException

class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?(.${format})?" {
			constraints {
				// apply constraints here
			}
		}

		"/"(view: "/index")
		"403"(controller: "errors", action: 'unauthorized')
		"500"(view: '/error')
		"500"(controller: "errors", action: "unauthorized", exception: AccessDeniedException)
	}
}
