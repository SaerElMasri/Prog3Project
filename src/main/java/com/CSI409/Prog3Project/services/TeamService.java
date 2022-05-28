package com.CSI409.Prog3Project.services;

import com.CSI409.Prog3Project.SqlFactory;
import com.CSI409.Prog3Project.beans.Team;
import com.CSI409.Prog3Project.mapper.MatchMapper;
import com.CSI409.Prog3Project.mapper.TeamMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    public TeamMapper teamMapper;
    SqlSession session;

    public List<Team> listOfTeams(){
        session = SqlFactory.getFactory().openSession();
        try{
            teamMapper = session.getMapper(TeamMapper.class);
            return teamMapper.listOfTeams();
        }catch (Exception ex){
            System.out.println("Error at listOfTeams, error: " + ex.getMessage());
            return null;
        }
    }

    public String getTeamByCountry(String countryName){
        session = SqlFactory.getFactory().openSession();
        try{
            teamMapper = session.getMapper(TeamMapper.class);
            return teamMapper.getTeamByCountry(countryName);
        }catch (Exception ex){
            System.out.println("Error at getTeamByCountry, error: " + ex.getMessage());
            return null;
        }
    }

}
