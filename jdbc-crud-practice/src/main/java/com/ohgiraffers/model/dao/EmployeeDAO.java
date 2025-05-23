package com.ohgiraffers.model.dao;

import com.ohgiraffers.model.dto.EmployeeDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import static com.ohgiraffers.common.JDBCTemplate.Close;

public class EmployeeDAO {

    private Properties prop = new Properties();

    public EmployeeDAO(){
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/employee-query.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public EmployeeDTO selectByIdEmp(Connection con, int id){
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String query = prop.getProperty("selectByIdEmp");

        EmployeeDTO employeeDTO = new EmployeeDTO();

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);

            rset = pstmt.executeQuery();

            if(rset.next()){
                employeeDTO.setName(rset.getString("EMP_NAME"));
                employeeDTO.setId(rset.getInt("EMP_ID"));
                employeeDTO.setEmpNumber(rset.getString("EMP_NO"));
                employeeDTO.setJobCode(rset.getString("JOB_CODE"));
                employeeDTO.setSalLevel(rset.getString("SAL_LEVEL"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Close(pstmt);
            Close(rset);
        }

        return employeeDTO;
    }

    public List<Map<Integer, String>> selectAllEmp(Connection con){
        Statement stmt = null;
        ResultSet rset = null;

        List<Map<Integer, String>> employeeList = null;

        String query = prop.getProperty("selectAllEmp");

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            employeeList = new ArrayList<>();

            while(rset.next()){
                Map<Integer, String> employee = new HashMap<>();
                employee.put(rset.getInt("EMP_ID"), rset.getString("EMP_NAME"));

                employeeList.add(employee);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employeeList;

    }

    public int insertEmp(Connection con, EmployeeDTO empDto){

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("insertEmp");

        try {
            pstmt = con.prepareStatement(query);

            /*notnull만 채움.*/
            pstmt.setInt(1, empDto.getId());
            pstmt.setString(2, empDto.getName());
            pstmt.setString(3, empDto.getEmpNumber());
            pstmt.setString(4, empDto.getJobCode());
            pstmt.setString(5, empDto.getSalLevel());


            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Close(pstmt);
        }

        return result;
    }

    public int modifyEmp(Connection con, int id, String name, String phone, int salary){

        PreparedStatement pstmt = null;
        int result = 0;

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/employee-query.xml"));
            String query = prop.getProperty("modifyEmp");

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setInt(3, salary);
            pstmt.setInt(4, id);

            result = pstmt.executeUpdate();


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            Close(pstmt);
            Close(con);
        }


        return result;
    }

    public int deleteEmp(Connection con, int id){

        PreparedStatement pstmt = null;

        int result = 0;

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/employee-query.xml"));
            String query = prop.getProperty("deleteEmp");

            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);

            result = pstmt.executeUpdate();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }




}
