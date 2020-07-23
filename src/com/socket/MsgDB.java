/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socket;

import com.socket.DBManager;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.PrintWriter;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author Fareeha
 */
public class MsgDB {
   public  void  SendMessageToClient(String name,String address,String message){
		
		try{
			Connection con=DBManager.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into smessage(Uname,Uaddress,Message) values(?,?,?)");
			ps.setString(1,name);
			ps.setString(2,address);
			ps.setString(3,message);
                        con.close();
                        JOptionPane.showMessageDialog(null,"Successfully save message in db");
			
		}catch(Exception e){JOptionPane.showMessageDialog(null,"Sorry, unable to insert in db!");}	
	}
   public  void  RecieveMessageFromClient(String name,String message){
		
		try{
			Connection con=DBManager.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into cmessage(Uname,Message) values(?,?)");
			ps.setString(1,name);
			ps.setString(2,message);
                        con.close();
                        JOptionPane.showMessageDialog(null,"Successfully save message in db");
			
		}catch(Exception e){JOptionPane.showMessageDialog(null,"Sorry, unable to insert in db!");}	
	}
}
