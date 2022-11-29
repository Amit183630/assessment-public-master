package com.xib.assessment.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xib.assessment.dto.AgentDTO;
import com.xib.assessment.dto.CreateAgentDTO;
import com.xib.assessment.dto.PagedData;
import com.xib.assessment.entity.Agent;
import com.xib.assessment.entity.Team;
import com.xib.assessment.exception.DataNotFoundException;
import com.xib.assessment.repository.AgentRepository;
import com.xib.assessment.service.AgentService;
import com.xib.assessment.service.TeamService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AgentServiceImpl implements AgentService {

	@Autowired
	AgentRepository agentRepository;
	
	@Autowired
	TeamService teamService;
	
	@Override
	public Agent getAgent(long id) {
		log.info("Getting agent with id:"+id);
		return agentRepository.findById(id).orElseThrow(()->{
			throw new DataNotFoundException("Agent not found with id:"+id);
		});
	}
	
	@Override
	public Agent addAgent(CreateAgentDTO createAgentDTO) {
		log.info("Agent create Request, agent details:{}",createAgentDTO.toString());
		Agent agent=Agent.builder()
					.firstName(createAgentDTO.getFirstName())
					.lastName(createAgentDTO.getLastName())
					.idNumber(createAgentDTO.getIdNumber())
					.build();
		return agentRepository.save(agent);
	}
	
	@Override
	public PagedData<AgentDTO> getAgentList(Integer pageSize,Integer pageNo) {

		log.info("Get Agent List pageSize:{},pageNo:{}",pageSize,pageNo);
		Pageable paging=null;
		if(pageSize!=null && pageNo!=null) {
			paging=PageRequest.of(pageNo, pageSize);
		}else {
			paging=Pageable.unpaged();
		}
		
		return new PagedData<>( agentRepository.getAllAgents(paging));
	}
	
	@Override
	public Agent assignTeam(long teamId, long agentId) {
		log.info("Assigning Team:{} to the Agent:{}",agentId,teamId);
		Team team=teamService.getTeam(teamId);
		Agent agent=getAgent(agentId);
		agent.setTeam(team);
		return agentRepository.save(agent);
	}
}
