package edu.javacourse.city.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PoolConnectionBuilder implements ConnectionBuilder
{
    public PoolConnectionBuilder() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
    }


    /*private static final Logger logger = LoggerFactory.getLogger(PoolConnectionBuilder.class);

    private DataSource dataSource;

    public PoolConnectionBuilder() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/cityRegister");
        } catch (NamingException e) {
            logger.error("", e);
        }
    }*/

    @Override
    public Connection getConnection() throws SQLException {
        //return dataSource.getConnection();
        return DriverManager.getConnection("jdbc:postgresql://localhost/city_register",
                "postgres","1");
    }
}
