package com.filereader.controller;

import java.sql.SQLException;
import java.util.Date;
import org.apache.log4j.Logger;
import com.filereader.service.FileReaderService;

public class FileReaderMain {

	static Logger logger = Logger.getLogger(FileReaderMain.class);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		logger.info("------------ [Program starts at " + new Date() + "] --------------");
		try {
			FileReaderService service = new FileReaderService();
			service.execute();
		} catch (Exception e) {
			logger.error("Exception in executing the scheduler", e);
		}
		logger.info("------------ [Program ends at " + new Date() + "] --------------");

	}
}
