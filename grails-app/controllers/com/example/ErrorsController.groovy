package com.example

import grails.converters.JSON
import grails.converters.XML
import org.springframework.http.HttpStatus


class ErrorsController {

	def unauthorized() {
		response.status = HttpStatus.UNAUTHORIZED.value()

		def model = [
				code: 403,
				messageCode: "default.error.unauthorized",
				messageText: g.message(code: "default.error.unauthorized")
		]

		withFormat {
			html {
				return model
			}
			json {
				render(model as JSON)
			}
			xml {
				render(model as XML)
			}
		}
	}
}
