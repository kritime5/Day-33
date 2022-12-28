package com.bridgelabz;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class DBDemo {
    public static void main(String[] args) {
        String jdbcURL="jdbc:mysql://localhost:3306/payroll_service1?useSSL.false";
        String userName="root";
        String password="mynameiskt";
        Connection con;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded ");
        }catch (ClassNotFoundException e){
            throw new IllegalStateException("Cannot find the driver in classpath",e);
        }
        listDrivers();
        try{
            System.out.println("Connecting to database:+jdbcURL");
            con= DriverManager.getConnection(jdbcURL,userName,password);
            System.out.println("connection is successful");
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void listDrivers(){
        Enumeration<Driver> driverlist=DriverManager.getDrivers();
        while(driverlist.hasMoreElements()){
            Driver driverClass=(Driver) driverlist.nextElement();
            System.out.println(" "+driverClass.getClass().getName());
        }

    }
}
