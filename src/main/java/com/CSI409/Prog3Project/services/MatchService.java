package com.CSI409.Prog3Project.services;

import com.CSI409.Prog3Project.SqlFactory;
import com.CSI409.Prog3Project.beans.Match;
import com.CSI409.Prog3Project.mapper.MatchMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    public MatchMapper matchMapper;
    SqlSession session;

    public void insertMatch(int id, String teamNo1, int teamNo1Goal, String teamNo2, int teamNo2Goals){
        session = SqlFactory.getFactory().openSession();
        try {
            matchMapper = session.getMapper(MatchMapper.class);
            matchMapper.insertMatch(id,teamNo1,teamNo1Goal,teamNo2,teamNo2Goals);
            session.commit();
            session.close();
        }catch (Exception ex){
            System.out.println("Error at insertMatch, error: " + ex.getMessage());
        }
    }

    public List<Match> findAll(){
        session = SqlFactory.getFactory().openSession();
        try{
            matchMapper = session.getMapper(MatchMapper.class);
            return matchMapper.findAll();
        }catch (Exception ex){
            System.out.println("Error at findAll, error: " + ex.getMessage());
            return null;
        }
    }

    public void insertGoals(int goalsTeam1, int goalsTeam2, int id){
        session = SqlFactory.getFactory().openSession();
        try{
            matchMapper = session.getMapper(MatchMapper.class);
            matchMapper.insertGoals(goalsTeam1, goalsTeam2, id);
            session.commit();
        }catch (Exception ex){
            System.out.println("Error at insertGoal. Error: " + ex.getMessage());
        }
    }


}
