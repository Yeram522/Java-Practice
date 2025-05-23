package com.ohgiraffers.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {

    static public Connection getConnection(){

        Connection con = null;
        Properties prop = new Properties();

        try {
            /*
            * public synchronized void load(Reader reader) throws IOException {
                     Objects.requireNonNull(reader, "reader parameter is null");
                     load0(new LineReader(reader));
               }
            * */
            prop.load(new FileReader("src/main/java/com/ohgiraffers/config/connection-info.properties"));

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");

            Class.forName(driver);

            con = DriverManager.getConnection(url, prop);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }

    /* comment. Connection, Statement, ResultSet 모두 Wrapper과 AutoClosable을 상속받고 있다.*/

    static public void Close(Connection con){
        try {
            if(con!= null && !con.isClosed()){
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static public void Close(Statement stmt){
        try {
            if(stmt!= null && !stmt.isClosed()){
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static public void Close(ResultSet rset){
        try {
            if(rset!= null && !rset.isClosed()){
                rset.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
