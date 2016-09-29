package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.crypto.Data;

public class DataBaseConnect {
	private Connection conn = null;
	public Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;

	public DataBaseConnect() {
		ConfigTool data = new ConfigTool();
		try {
			Class.forName(data.getDriver());
			conn = DriverManager.getConnection(data.getUrl());
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		try {
			rs = stmt.executeQuery(sql);
			return rs;
		} catch (SQLException se) {
			System.out.println("DataBaseConnect.executeQuery() ERROR:" + se.getMessage());
		}
		return rs;
	}

	public int executeUpdate(String ssql) throws SQLException {
		int iupdate = 0;
		try {
			iupdate = stmt.executeUpdate(ssql);
			return iupdate;
		} catch (SQLException se) {
			System.out.println("DataBaseConnect.executeUpdate() ERROR:" + se.getMessage());
		}
		return iupdate;
	}

	public void free() throws SQLException {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			System.out.println("DataBaseConnect.free() ERROR:" + se.getMessage());
		}
	}

	public static void main(String[] args) throws SQLException {
		ConfigTool data = new ConfigTool();
		DataBaseConnect conn = new DataBaseConnect();
		conn.executeQuery(data.getValidationQuery());
		System.out.println("MySql连接成功！");
	}
}
