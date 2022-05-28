package com.CSI409.Prog3Project;

import jdk.internal.loader.Resource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.io.Reader;

public class SqlFactory {

    private static SqlSessionFactory sqlSessionFactory;
    private SqlFactory(){}

    static {
        String resource = "my-batis-config.xml";
        try{
            InputStream in = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        }catch (Exception exception){
            System.out.println("Error loading config");
        }

    }

    public static SqlSessionFactory getFactory() {
        return sqlSessionFactory;
    }


}
