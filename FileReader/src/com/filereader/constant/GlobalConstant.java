package com.filereader.constant;
import com.filereader.util.PropertyReader;

public class GlobalConstant {

	private GlobalConstant(){}
	
	public static final String APP_DEPLOYMENT_LEVEL = PropertyReader.getValue("APP_DEPLOYMENT_LEVEL");
	public static final String ORACLE_DRIVER = "oracle.driver";
	public static final String ORACLE_URL = APP_DEPLOYMENT_LEVEL + ".oracle.url";
	public static final String ORACLE_USERID = APP_DEPLOYMENT_LEVEL + ".oracle.userid";
	public static final String ORACLE_PASSWORD = APP_DEPLOYMENT_LEVEL + ".oracle.password";
	
	public static final String MSSQL_DRIVER = "mssql.driver";
	public static final String MSSQL_URL = APP_DEPLOYMENT_LEVEL + ".mssql.url";
	public static final String MSSQL_USERID = APP_DEPLOYMENT_LEVEL + ".mssql.userid";
	public static final String MSSQL_PASSWORD = APP_DEPLOYMENT_LEVEL + ".mssql.password";
	
	public static final String FILE1_NAME = APP_DEPLOYMENT_LEVEL + ".file1.filename";
	public static final String FILE1_LOCATION = APP_DEPLOYMENT_LEVEL + ".file1.location";
	public static final String FILE1_DELIMETER = APP_DEPLOYMENT_LEVEL + ".file1.delimeter";
	
	public static final String FILE2_NAME = APP_DEPLOYMENT_LEVEL + ".file2.filename";
	public static final String FILE2_LOCATION = APP_DEPLOYMENT_LEVEL + ".file2.location";
	public static final String FILE2_DELIMETER = APP_DEPLOYMENT_LEVEL + ".file2.delimeter";
	
	public static final String BACK_SLASH = "\\";


}
