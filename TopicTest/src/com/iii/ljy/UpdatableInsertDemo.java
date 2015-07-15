package com.iii.ljy;

import java.sql.*;

// Updatable - insert
public class UpdatableInsertDemo {
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		try {     
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=project";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
			
			String qryStmt = "SELECT * FROM Class";
			PreparedStatement stmt = conn.prepareStatement(qryStmt, 
				ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery();
			
			rs.moveToInsertRow();
			rs.updateString(1, "1011");
			rs.updateString(2, "Jean Tsao");
//			rs.updateString(3, "2008/10/10");
//			rs.updateDouble(4, 55000);
//			rs.updateInt(5, 100);
//			rs.updateString(6, "senior engineer");
			rs.insertRow();

			// 查詢資料庫的資料是否修改	
			stmt = conn.prepareStatement(qryStmt);
			rs = stmt.executeQuery();
			while(rs.next()) {
				System.out.print("c_id = " + rs.getString("c_id") + ", ");
				System.out.println("c_name = " + rs.getString("c_name"));
			}	
		} catch (SQLException e) {
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
}// end of class UpdatableInsertDemo
