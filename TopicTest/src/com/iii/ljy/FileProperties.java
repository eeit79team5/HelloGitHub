package com.iii.ljy;

import java.sql.*;

// 採用屬性檔方式載入JDBC Driver
public class FileProperties {
	public static void main(String[] args) {
		Connection conn = null;
		try {     
			conn = Database.getConnection();
			String qryStmt = "SELECT * FROM emp3";
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				System.out.print("name1 = " + rs.getString("name1") + ", ");
				System.out.println("name2 = " + rs.getString("name2") + ", ");
				System.out.println("id = " + rs.getDouble("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
		}
	}// end of main()
}// end of class FileProperties 
