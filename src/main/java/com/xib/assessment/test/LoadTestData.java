package com.xib.assessment.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xib.assessment.entity.Agent;
import com.xib.assessment.entity.Manager;
import com.xib.assessment.entity.Team;
import com.xib.assessment.repository.AgentRepository;
import com.xib.assessment.repository.ManagerRepository;
import com.xib.assessment.repository.TeamRepository;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Component
public class LoadTestData {
    @Autowired
    AgentRepository agentRepository;

    @Autowired
    TeamRepository teamRepository;
    
    @Autowired
    ManagerRepository managerRepository;

    @PostConstruct
    @Transactional
    public void execute() {
    	

        Manager manager1= createManager("Amit", "Kumar");
        Manager manager2= createManager("Jatin", "Kumar");
        Set<Manager> maangersSet1=new HashSet<>();
        maangersSet1.add(manager1);
        maangersSet1.add(manager2);

        Manager manager3= createManager("Raj", "Kumar");
        Manager manager4= createManager("Yaman", "Kumar");
        Set<Manager> maangersSet2=new HashSet<>();
        maangersSet2.add(manager3);
        maangersSet2.add(manager4);
        Team team1 = createTeam("Marvel",maangersSet1);
        Team team2 = createTeam("DC",maangersSet2);

        createAgent("Bruce", "Banner", "1011125190081", team1);
        createAgent("Tony", "Stark", "6912115191083", team1);
        createAgent("Peter", "Parker", "7801115190084", team1);
        createAgent("Bruce", "Wayne", "6511185190085", team2);
        createAgent("Clark", "Kent", "5905115190086",team2);
        
        createManager("Amit", "Kumar");
        createManager("Jatin", "Kumar");
        
    }

    private Team createTeam(String name,Set<Manager> managers) {
        Team t = new Team();
        t.setName(name);
        t.setManagers(managers);
        return teamRepository.save(t);
    }

    private Agent createAgent(String firstName, String lastName, String idNumber,  Team team) {
        Agent a = new Agent();
        a.setFirstName(firstName);
        a.setLastName(lastName);
        a.setIdNumber(idNumber);
        a.setTeam(team);
        return agentRepository.save(a);
    }
    
    private Manager createManager(String firstName,String lastName) {
    	Manager manager=new Manager();
    	manager.setFirstName(firstName);
    	manager.setLastName(lastName);
    	return managerRepository.save(manager);
    }
}

