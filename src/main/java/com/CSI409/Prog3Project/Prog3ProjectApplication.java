package com.CSI409.Prog3Project;

import com.CSI409.Prog3Project.beans.Match;
import com.CSI409.Prog3Project.mapper.MatchMapper;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Prog3ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Prog3ProjectApplication.class, args);
	}

}
