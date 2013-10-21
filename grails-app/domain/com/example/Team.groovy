package com.example

class Team {

	String name

	static constraints = {
	}

	static hasMany = [members: TeamMember]
}
