package com.xib.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xib.assessment.dto.CreateAgentDTO;
import com.xib.assessment.dto.DataResponse;
import com.xib.assessment.service.AgentService;

/**
 * 
 * @author Amit
 *
 */
@RestController
public class AgentController {

	@Autowired
	AgentService agentService;
	
	/**
	 * This API used for getting agent full details
	 * @param id
	 * @return Agent Details
	 */
	
    @GetMapping("/agent/{id}")
    public ResponseEntity<?> findAgent(@PathVariable("id") Long id) {
    	return ResponseEntity.ok(
    			new DataResponse(true,agentService.getAgent(id),"Agent details retrieved successfully"));
       
    }
    /**
     * This API requires the Agent Details
     * and create it
     * @param createAgentDTO
     * @return
     */
    @PostMapping("/agent")
    public ResponseEntity<?> createAgent(@RequestBody CreateAgentDTO createAgentDTO) {
    	return ResponseEntity.ok(
    			new DataResponse(true,agentService.addAgent(createAgentDTO),
    					"Agent created successfully"));
       
    }
 
    /**
     * this API returns the Agent List with pagination
     * @param pageSize
     * @param pageNo
     * @return
     */
    @GetMapping("/agents")
    public ResponseEntity<?> getAllAgent(@RequestParam(required = false) Integer pageSize,@RequestParam(required = false) Integer pageNo) {
    	return ResponseEntity.ok(
    			new DataResponse(true,agentService.getAgentList(pageSize, pageNo),"Agent List retrieved successfully"));
       
    }
    
    /**
     * This API assign a agent to the team
     * @param teamId
     * @param id
     * @return
     */
    @PutMapping("/team/{id}/agent/{agentId}")
    public ResponseEntity<?> assignTeam(@PathVariable(name ="id") long teamId,@PathVariable(name = "agentId") long id) {
    	return ResponseEntity.ok(
    			new DataResponse(true,agentService.assignTeam(teamId, id),"Team assigned to the agent"));
       
    }


}
