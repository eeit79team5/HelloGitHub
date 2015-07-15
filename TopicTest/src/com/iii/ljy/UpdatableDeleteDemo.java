package com.iii.ljy;

import java.sql.*;

// Updatable - delete
public class UpdatableDeleteDemo {
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		try {     
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=jdbc";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
			
			String qryStmt = "SELECT * FROM employee";
			PreparedStatement stmt = conn.prepareStatement(qryStmt, 
				ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String empno = rs.getString(1);
				if (empno.equals("1009"))
					rs.deleteRow();
			}

			// 查詢資料庫的資料是否修改	
			stmt = conn.prepareStatement(qryStmt);
			rs = stmt.executeQuery();
			while(rs.next()) {
				System.out.print("name = " + rs.getString("ename") + ", ");
				System.out.println("salary = " + rs.getDouble("salary"));
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
}// end of class UpdatableDeleteDemo
