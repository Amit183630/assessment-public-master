package com.xib.assessment.service;


import com.xib.assessment.dto.AgentDTO;
import com.xib.assessment.dto.CreateAgentDTO;
import com.xib.assessment.dto.PagedData;
import com.xib.assessment.entity.Agent;

/**
 * 
 * @author Amit
 *
 */
public interface AgentService {

	/**
	 * This service operation returns the agent details
	 * @param id
	 * @return Agent
	 */
	Agent getAgent(long id);
	/**
	 * This service operation create the agent into the DB
	 * @param createAgentDTO
	 * @return Agent
	 */
	Agent addAgent(CreateAgentDTO createAgentDTO);
	
	/**
	 * This service operation returns the agent list
	 * @param pageSize
	 * @param pageNo
	 * @return PagedData<AgentDTO>
	 */
	PagedData<AgentDTO> getAgentList(Integer pageSize,Integer pageNo);
	
	/**
	 * This service operation assign particular Team to the Agent
	 * @param teamId
	 * @param agentId
	 * @return Agent
	 */
	Agent assignTeam(long teamId,long agentId);
}
