package com.example

class Authority {

	String authority

	static constraints = {
		authority(blank: false, nullable: false, unique: true)
	}
}
