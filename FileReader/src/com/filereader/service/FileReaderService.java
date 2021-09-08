package com.filereader.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import com.filereader.constant.GlobalConstant;
import com.filereader.dao.FileReaderDao;
import com.filereader.util.PropertyReader;

public class FileReaderService {

	static Logger logger = Logger.getLogger(FileReaderService.class);

	public void execute() throws IOException, ClassNotFoundException, SQLException {

		Double totalOfvalues = readFile1AndCalculateTotal();
		logger.info("totalOfvalues : " + totalOfvalues);
		Double average = readFile2AndCalculateAverage();
		logger.info("average : " + average);
		FileReaderDao dao = new FileReaderDao();
		dao.insertDataIntoDB(PropertyReader.getValue(GlobalConstant.FILE1_NAME), PropertyReader.getValue(GlobalConstant.FILE2_NAME), totalOfvalues, average);		
		
	}

	private Double readFile1AndCalculateTotal() throws IOException {

		logger.info("In readFile1AndCalculateTotal() of FileReaderService");
		Double totalValue = 0.0;

		File file = new File(PropertyReader.getValue(GlobalConstant.FILE1_LOCATION) + File.separator
				+ PropertyReader.getValue(GlobalConstant.FILE1_NAME));

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String record;
			while ((record = br.readLine()) != null) {
				totalValue = totalValue + Double.valueOf(record
						.split(GlobalConstant.BACK_SLASH + PropertyReader.getValue(GlobalConstant.FILE1_DELIMETER))[2]);
			}
		} catch (Exception e) {
			logger.error("Exception in reading file1", e);
			throw e;
		}
		return totalValue;

	}

	private Double readFile2AndCalculateAverage() throws NumberFormatException, IOException {

		logger.info("In readFile2AndCalculateAverage() of FileReaderService");
		Double sum = 0.0;
		Double avg = 0.0;
		Long count = 0l;

		File file = new File(PropertyReader.getValue(GlobalConstant.FILE2_LOCATION) + File.separator
				+ PropertyReader.getValue(GlobalConstant.FILE2_NAME));

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String record;
			while ((record = br.readLine()) != null) {
				count++;
				sum = sum + Double.valueOf(record
						.split(GlobalConstant.BACK_SLASH + PropertyReader.getValue(GlobalConstant.FILE2_DELIMETER))[3]);
			}
			avg = sum / count;
		} catch (Exception e) {
			logger.error("Exception in reading file2", e);
			throw e;
		}

		return avg;

	}
}
