package com.example

class TeamMember {

	static belongsTo = [team: Team]

	static constraints = {
	}

	static hasOne = [user: User]

	static mapping = {
	}
}
