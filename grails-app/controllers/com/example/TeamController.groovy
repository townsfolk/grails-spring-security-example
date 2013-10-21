package com.example

import org.springframework.security.access.annotation.Secured

class TeamController {

	static defaultAction = "list"

	@Secured("isAuthenticated()")
	def create() {
		log.debug("Creating new team")
	}

	@Secured("isAuthenticated()")
	def edit(Team team) {
		log.debug("Editing team: $team")
		if (!team?.hasErrors()) {
			[team: team]
		} else {
			[team: null]
		}
	}

	def list() {
		log.debug("Listing all teams")
		[teams: Team.findAll()]
	}

	@Secured("isAuthenticated()")
	def save(Team team) { // using Team as a command object for form data
		log.debug("Attempting to save a team: $team")
		if (team.save()) {
			redirect(action: 'show', id: team.id)
		} else {
			[teamForm: team]
		}
	}

	def show(Team team) {
		log.debug("Showing a team: $team")
		if (!team.hasErrors()) {
			[team: team]
		} else {
			[team: null]
		}
	}
}
