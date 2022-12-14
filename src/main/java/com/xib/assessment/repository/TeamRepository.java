package com.xib.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xib.assessment.dto.TeamDTO;
import com.xib.assessment.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
	

	@Query(value="SELECT new com.xib.assessment.dto.TeamDTO(team.id,team.name) FROM Team team")
	List<TeamDTO> getAllTeam();
	
	@Query(value="SELECT new com.xib.assessment.dto.TeamDTO(team.id,team.name) FROM Team team WHERE (size(team.managers)=0) OR "
			+ " team.id NOT IN(SELECT agent.team.id FROM Agent agent) ")
	List<TeamDTO> getEmptyTeams();
}
