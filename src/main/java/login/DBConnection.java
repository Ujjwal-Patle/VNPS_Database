package login;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static final String url = "jdbc:oracle:thin:@localHost:1521:xe";
	private static final String userName = "VNPS";
	private static final String passWord = "abc";
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Connection getCon()throws Exception
	{
		return DriverManager.getConnection(url,userName,passWord);
	}
}
