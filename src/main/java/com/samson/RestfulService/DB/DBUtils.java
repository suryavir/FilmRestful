package com.samson.RestfulService.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	public static Connection getSQLConn() {
		Connection connection = null;
		try {
			// Load the JDBC driver
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);

			// Create a connection to the database
			String serverName = "127.0.0.1";
			String portNumber = "3306";
			String dbname = "sakila";
			String url = "jdbc:mysql://" + serverName + ":" + portNumber
					+ "/" + dbname;

			String username = "root";
			String password = "manutd403";
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found" + e);
		} catch (SQLException e) {
			System.out.println("Sql exception" + e);

		}
		return connection;

	}

	public static void closeDBConnection(Statement stmt, ResultSet rs,
			Connection con, PreparedStatement pstmt) {
		try {
			if(null != stmt ) stmt.close();
			pstmt.close();
			if(null != rs) rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeDBConnection(Statement stmt, ResultSet rs,
			Connection con, StringBuilder sb) {
		try {
			sb = null;
			stmt.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeDBConnection(Statement stmt, Connection con,
			StringBuilder sb) {
		try {
			sb = null;
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String ifNullRetBlank(String str) {
		return str == null ? "" : str;
	}

}

