package com.xib.assessment.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xib.assessment.dto.CreateManagerDTO;
import com.xib.assessment.entity.Manager;
import com.xib.assessment.repository.ManagerRepository;
import com.xib.assessment.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	ManagerRepository repository;
	
	@Override
	public Manager addManager(CreateManagerDTO createManagerDTO) {
		
		return repository.save(Manager.builder()
				.firstName(createManagerDTO.getFirstName())
				.lastName(createManagerDTO.getLastName())
				.build());
	}
	
}
