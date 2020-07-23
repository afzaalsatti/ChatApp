/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socket;
import com.socket.DBManager;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.PrintWriter;
import javax.swing.*;
import java.sql.*;
import com.socket.History;
import com.socket.Download;
import com.socket.Message;
import com.ui.ChatFrame;
import java.io.*;
import java.net.*;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Fareeha
 */
public class UserDB {
    
  public void UserDB(){};
    
    public  void register(String name,String password){
		int status=0;
		try{  
                    
			Connection con=DBManager.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into userdata(Uname,password) values(?,?)");
			ps.setString(1,name);
			ps.setString(2,password);
					
                        status=ps.executeUpdate();
			con.close();
                        System.out.print("Successfully register");
			
		}catch(Exception e){
                    System.out.println("no");
                        ;}
		
	}
    
   public static boolean login(String name,String password){
		boolean status=false;
		try{
			Connection con=DBManager.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from userdata where Uname=? and Upassword=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
                       
		}catch(Exception e){System.out.println("no");}
		return status;
	}
   
   public static int delete_account(String name){
		int status=0;
		try{
			Connection con=DBManager.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from userdata where Uname=?");
			ps.setString(1,name);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
 public boolean IsUserExists(String name)
	{		boolean status=false;
		try{
			Connection con=DBManager.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from userdata where Uname=?");
			ps.setString(1,name);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
                       
		}catch(Exception e){JOptionPane.showMessageDialog(null,"user not exist");}
		return status;
	}

    int register(String hira, String string, String fareeharafaqatgmailcom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
