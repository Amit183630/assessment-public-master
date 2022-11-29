package com.xib.assessment.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xib.assessment.dto.CreateTeamDTO;
import com.xib.assessment.dto.TeamDTO;
import com.xib.assessment.entity.Team;
import com.xib.assessment.exception.DataNotFoundException;
import com.xib.assessment.repository.TeamRepository;
import com.xib.assessment.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService{

	@Autowired
	TeamRepository repository;
	@Override
	public List<TeamDTO> getTeamList() {
		
		return repository.getAllTeam();
	}
	
	@Override
	public Team getTeam(long id) {
		
		return repository.findById(id).orElseThrow(()->{
			throw new DataNotFoundException("Team not found with id:"+id);
		});
	}
	
	@Override
	public Team addTeam(CreateTeamDTO createTeamDTO) {
		return repository.save(Team.builder()
				.name(createTeamDTO.getName())
				.build()
				);
	}
	
}
