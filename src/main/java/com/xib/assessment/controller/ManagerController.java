package com.xib.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xib.assessment.dto.CreateManagerDTO;
import com.xib.assessment.dto.DataResponse;
import com.xib.assessment.service.ManagerService;

/**
 * 
 * @author Amit
 *
 */
@RestController
public class ManagerController {

	@Autowired
	ManagerService service;
	
	/**
	 * This API create the new manager
	 * @param createManagerDTO
	 * @return
	 */
	@PostMapping("/manager")
	public ResponseEntity<?> createManager(@RequestBody CreateManagerDTO createManagerDTO){
		return ResponseEntity.ok(
    			new DataResponse(true,service.addManager(createManagerDTO),"Manager created successfully"));
	}
}
