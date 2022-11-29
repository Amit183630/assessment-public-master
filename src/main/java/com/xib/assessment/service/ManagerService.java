package com.xib.assessment.service;

import com.xib.assessment.dto.CreateManagerDTO;
import com.xib.assessment.entity.Manager;

public interface ManagerService {

	/**
	 * This service operation create new manager into the DB
	 * @param createManagerDTO
	 * @return Manager
	 */
	Manager addManager(CreateManagerDTO createManagerDTO);
}
