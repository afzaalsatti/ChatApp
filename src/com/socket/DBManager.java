package com.socket;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class DBManager
{
           
public static Connection getConnection()
{
        Connection conn = null;
        try
        {
                Class.forName("com.mysql.jdbc.Driver");

                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?zeroDateTimeBehavior=convertToNull","root","" );
              

        }
        catch(Exception e)
        {
                 System.out.print("Do not connect to DB - Error:"+e);
        }
         return conn;
}

}