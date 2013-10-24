package com.example

import grails.converters.JSON
import grails.converters.XML

import static org.springframework.http.HttpStatus.BAD_REQUEST
import static org.springframework.http.HttpStatus.UNAUTHORIZED

class ErrorsController {

	def unauthorized() {
		response.status = UNAUTHORIZED.value()

		def model = [
				code: UNAUTHORIZED.value(),
				messageCode: "default.error.unauthorized",
				messageText: g.message(code: "default.error.unauthorized", args: [UNAUTHORIZED.reasonPhrase])
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

	def unknownuser() {
		response.status = BAD_REQUEST.value()

		def model = [
				code: BAD_REQUEST.value(),
				messageCode: "default.error.unknownuser",
				messageText: g.message(code: "default.error.unknownuser", args: [BAD_REQUEST.reasonPhrase])
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
