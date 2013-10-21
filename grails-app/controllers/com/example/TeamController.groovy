package com.example

import org.springframework.security.access.prepost.PreAuthorize

class TeamController {

	static defaultAction = "list"

	@PreAuthorize("isAuthenticated()")
	def create() {
		log.debug("Creating new team")
	}

	@PreAuthorize("isAuthenticated()")
	def edit(Team team) {
		log.debug("Editing team: $team")
		if (!team?.hasErrors()) {
			[team: team]
		} else {
			[team: null]
		}
	}

	@PreAuthorize("permitAll")
	def list() {
		log.debug("Listing all teams")
		[teams: Team.findAll()]
	}

	@PreAuthorize("isAuthenticated()")
	def save(Team team) { // using Team as a command object for form data
		log.debug("Attempting to save a team: $team")
		if (team.save()) {
			redirect(action: 'show', id: team.id)
		} else {
			[teamForm: team]
		}
	}

	@PreAuthorize("permitAll")
	def show(Team team) {
		log.debug("Showing a team: $team")
		if (!team.hasErrors()) {
			[team: team]
		} else {
			[team: null]
		}
	}
}
