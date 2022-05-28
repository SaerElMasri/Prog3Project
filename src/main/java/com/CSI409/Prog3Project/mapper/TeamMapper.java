package com.CSI409.Prog3Project.mapper;

import com.CSI409.Prog3Project.beans.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeamMapper {

    @Select("select * from teams_table")
    public List<Team> listOfTeams();

    @Select("SELECT * FROM teams_table where upper(country) = upper(#{teamCountry})")
    public String getTeamByCountry(@Param("teamCountry") String country);
}
