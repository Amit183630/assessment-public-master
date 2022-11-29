package com.xib.assessment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.xib.assessment.dto.DataResponse;
import com.xib.assessment.service.TeamService;

/**
 * 
 * @author Amit
 *
 */
@RestController
public class TeamController {

	@Autowired
	TeamService service;
	
	/**
	 * This API returns the Team List
	 * @return
	 */
	@GetMapping("/teams")
	public ResponseEntity<?> getAllTeams(){
		
		return ResponseEntity.ok(
				new DataResponse(true, 
						service.getTeamList(), "Team List retrieved succesfully"));
	}
	/**
	 * This API returns the team info
	 * @param id
	 * @return
	 */
	@GetMapping("/team/{id}")
	public ResponseEntity<?> getTeamDetails(@PathVariable long id){
		
		return ResponseEntity.ok(
				new DataResponse(true,
						service.getTeam(id), "Team Details retrieved succesfully"));
	}
	

	
	
}
