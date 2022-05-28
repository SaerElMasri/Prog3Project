package com.CSI409.Prog3Project.controller;

import com.CSI409.Prog3Project.beans.Team;
import com.CSI409.Prog3Project.services.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    public TeamService service;

    @GetMapping("/allTeams")
    public List<Team> allTeams(){
        ArrayList<Team> teams = (ArrayList<Team>) service.listOfTeams();
        return teams;
    }

    @GetMapping("/searchTeam")
    public String getTeamByCountry(@RequestParam() String country){
        String searchTeam = country;
        return service.getTeamByCountry(searchTeam);
    }




}
