package com.CSI409.Prog3Project.controller;

import com.CSI409.Prog3Project.services.MatchService;
import com.CSI409.Prog3Project.beans.Match;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/match")
public class MatchController {

    public MatchService matchService;

    @GetMapping("/allMatches")
    public String AllMatch(){
        ArrayList<Match> matches =(ArrayList<Match>)matchService.findAll();
        String toString = "";
        for(int i = 0; i < matches.size(); i++){
            Match currentMatch = matches.get(i);
            toString = "Match ID: " + currentMatch.getMatchID() + "\nTeam 1: " + currentMatch.getTeam1() + ", Goals: " + currentMatch.getTeam1Score()
                    + "\nTeam 2: " + currentMatch.getTeam2() + ", Goals: " + currentMatch.getTeam2score();
        }
        return toString;
    }

    @GetMapping("/insertMatch")
    public String insertMatch(@RequestParam() int id,
                             @RequestParam() String team1,
                             @RequestParam(required = false) int team1Score,
                             @RequestParam() String team2,
                             @RequestParam(required = false) int team2Score){
        int match_id = id;
        String teamNo1 = team1;
        int teamNo1Goals = team1Score;
        String teamNo2 = team2;
        int teamNo2Goals = team2Score;
        matchService.insertMatch(match_id, teamNo1, team1Score, teamNo2, team2Score);
        return "Match added";
    }

    @GetMapping("/insertGoals")
    public String insertGoals(@RequestParam() int id,
                           @RequestParam() int teamNo1Scores,
                           @RequestParam() int teamNo2Goals){

        int match_id = id;
        int firstTeam = teamNo1Scores;
        int secondTeam = teamNo2Goals;
        matchService.insertGoals(firstTeam, secondTeam, match_id);
        return "Match Updated";
    }

    @GetMapping("/test")
    public String msg(){
        return "test";
    }
}
