package com.filereader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class FileReaderDao {
	
	static Logger logger = Logger.getLogger(FileReaderDao.class);
	
	public void insertDataIntoDB(String file1Name, String file2Name, Double totalOfvalues, Double average) throws ClassNotFoundException, SQLException {
		
		logger.info("In insertDataIntoDB() of FileReaderDao");
		
		Connection con = DBConfig.getOracleConnection();
		
		// Open SQL server connection for SQL Server database
		//Connection con = DBConfig.getSqlServerConnection();
		con.setAutoCommit(false);
		
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		
		try {
			
			String insert1 = "INSERT INTO TYPE1FILETOTALS(FILE_NAME, TOTAL) VALUES(?,?)";
			String insert2 = "INSERT INTO TYPE2FILEAVERAGES(FILE_NAME, AVERAGE) VALUES(?,?)";

			stmt1 = con.prepareStatement(insert1);
			stmt2 = con.prepareStatement(insert2);
				
			insertDataForFile1(stmt1, file1Name, totalOfvalues);
			insertDataForFile2(stmt2, file2Name, average);
		
			con.commit();
			logger.info("Data has been commited for both the tables");
			
		}catch(Exception e) {
			con.rollback();
			logger.error("Exception in inserting data in one of the table", e);
			throw e;
		}finally {
			DBConfig.clearOracleConnection(stmt1, null, con);
			DBConfig.clearOracleConnection(stmt2, null, con);
		}
	}

	private void insertDataForFile1(PreparedStatement stmt1, String file1Name, Double totalOfvalues) throws SQLException {
		logger.info("Inserting data into TYPE1FILETOTALS");
		stmt1.setString(1, file1Name);
		stmt1.setString(2, String.valueOf(totalOfvalues));
		
		stmt1.execute();
	}

	private void insertDataForFile2(PreparedStatement stmt2, String file2Name, Double average) throws SQLException {
		logger.info("Inserting data into TYPE2FILEAVERAGES");
		stmt2.setString(1, file2Name);
		stmt2.setString(2, String.valueOf(average));
		
		stmt2.execute();
		
	}

}
