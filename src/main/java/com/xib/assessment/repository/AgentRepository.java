package com.xib.assessment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xib.assessment.dto.AgentDTO;
import com.xib.assessment.entity.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long> {

	@Query(value="SELECT new com.xib.assessment.dto.AgentDTO (agent.id,agent.firstName,agent.lastName) FROM Agent agent")
	Page<AgentDTO> getAllAgents(Pageable paging);
}
