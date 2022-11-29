package com.xib.assessment.service;

import java.util.List;

import com.xib.assessment.dto.CreateTeamDTO;
import com.xib.assessment.dto.TeamDTO;
import com.xib.assessment.entity.Team;

public interface TeamService {

	/**
	 * This service Operation returns the list with team info
	 * @return List<TeamDTO>
	 */
	List<TeamDTO> getTeamList();
	
	/**
	 * This service operation requires the team id and returns the Team details
	 * @param id
	 * @return Team
	 */
	Team getTeam(long id);
	
	/**
	 * This service operation create the Team into the DB
	 * @param createTeamDTO
	 * @return Team
	 */
	Team addTeam(CreateTeamDTO createTeamDTO);
}
