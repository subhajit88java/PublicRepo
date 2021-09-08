package com.filereader.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.filereader.constant.GlobalConstant;
import com.filereader.util.PropertyReader;

public class DBConfig {

	static Logger logger = Logger.getLogger(DBConfig.class);

	public static Connection getOracleConnection() throws ClassNotFoundException, SQLException {

		try {

			String ORACLE_DRIVER = PropertyReader.getValue(GlobalConstant.ORACLE_DRIVER);
			String ORACLE_URL = PropertyReader.getValue(GlobalConstant.ORACLE_URL);
			String ORACLE_USERID = PropertyReader.getValue(GlobalConstant.ORACLE_USERID);
			String ORACLE_PASSWORD = PropertyReader.getValue(GlobalConstant.ORACLE_PASSWORD);

			logger.info("Oracle Driver loaded : " + ORACLE_DRIVER);
			logger.info("Oracle URL loaded : " + ORACLE_URL);

			Class.forName(ORACLE_DRIVER);

			Connection con = DriverManager.getConnection(ORACLE_URL, ORACLE_USERID, ORACLE_PASSWORD);

			logger.info("Oracle connection has been created successfully");

			return con;
		} catch (Exception e) {
			logger.error("Unable to create Oracle connection", e);
			throw e;
		}
	}

	public static Connection getSqlServerConnection() throws ClassNotFoundException, SQLException {

		try {

			String MSSQL_DRIVER = PropertyReader.getValue(GlobalConstant.MSSQL_DRIVER);
			String MSSQL_URL = PropertyReader.getValue(GlobalConstant.MSSQL_URL);
			String MSSQL_USERID = PropertyReader.getValue(GlobalConstant.MSSQL_USERID);
			String MSSQL_PASSWORD = PropertyReader.getValue(GlobalConstant.MSSQL_PASSWORD);

			logger.info("MsSql Driver loaded : " + MSSQL_DRIVER);
			logger.info("MsSql URL loaded : " + MSSQL_URL);

			Class.forName(MSSQL_DRIVER);

			Connection con = DriverManager.getConnection(MSSQL_URL, MSSQL_USERID, MSSQL_PASSWORD);

			logger.info("MsSql connection has been created successfully");

			return con;
		} catch (Exception e) {
			logger.error("Unable to create MsSql connection", e);
			throw e;
		}
	}

	public static void clearOracleConnection(Statement stmt, ResultSet rs, Connection con) {
		try {
			if (stmt != null && !stmt.isClosed()) {
				stmt.close();
				logger.info("Oracle statement has been closed");
			}

		} catch (Exception e) {
			logger.error("Unable to close Oracle statement", e);
		}

		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
				logger.info("Oracle resultset has been closed");
			}
		} catch (Exception e) {
			logger.error("Unable to close Oracle resultset", e);
		}

		try {
			if (con != null && !con.isClosed()) {
				con.close();
				logger.info("Oracle connection has been closed");
			}
		} catch (Exception e) {
			logger.error("Unable to close Oracle connection", e);
		}
	}

	public static void clearMsSqlConnection(Statement stmt, ResultSet rs, Connection con) {
		try {
			if (stmt != null && !stmt.isClosed())
				stmt.close();
		} catch (Exception e) {
			logger.error("Unable to close MsSql statement", e);
		}

		try {
			if (rs != null && !rs.isClosed())
				rs.close();
		} catch (Exception e) {
			logger.error("Unable to close MsSql resultset", e);
		}

		try {
			if (con != null && !con.isClosed())
				con.close();
		} catch (Exception e) {
			logger.error("Unable to close MsSql connection", e);
		}
	}

}
