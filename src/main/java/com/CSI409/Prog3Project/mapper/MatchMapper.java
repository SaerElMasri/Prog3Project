package com.CSI409.Prog3Project.mapper;

import com.CSI409.Prog3Project.beans.Match;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MatchMapper {

    @Select("select * from match_table")
    public List<Match> findAll();

    @Insert("insert into match_table(matchID, team1, team1Score, team2, team2Score) values (#{match_id}, #{firstTeam}, #{firstTeamScore}, #{secondTeam}, #{secondTeamScore})")
    public void insertMatch(@Param("matchID") int id,
                            @Param("firstTeam") String teamNo1,
                            @Param("firstTeamScore") int teamNo1Score,
                            @Param("secondTeam") String teamNo2,
                            @Param("secondTeamScore") int teamNo2Score);

    @Update("UPDATE match_table set team1Score = #{firstTeamGoals} and team2Score = #{secondTeamGoals} where matchID = #{id}")
    public void insertGoals(@Param("firstTeamGoals") int goals1,
                            @Param("secondTeamGoals") int goals2,
                            @Param("id") int match_id);

}
