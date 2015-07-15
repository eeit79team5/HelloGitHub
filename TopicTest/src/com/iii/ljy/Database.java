package com.iii.ljy;

import java.sql.*;
import java.io.*;
import java.util.*;

public class Database {
	public static Connection getConnection() throws Exception {
    	Properties props = new Properties();
		FileInputStream in = new FileInputStream("res/sqlserver.properties");
    	props.load(in);
    	in.close();
    	String url = props.getProperty("jdbc.url");
    	String user = props.getProperty("jdbc.user");
		String password = props.getProperty("jdbc.password");
		return DriverManager.getConnection(url, user, password);
	}// end of getConnection()
}// end of class Database