package login;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StdRegDAO 
{
	int k = 0;
	Connection con;
	public int insertData(studentBean sb)
	{
		try {
			con=DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("Insert into student values(?,?,?,?,?,?,?)");
			ps.setString(1, sb.getStdRollNo());
			ps.setString(2, sb.getStdName());
			ps.setString(3, sb.getStdClass());
			ps.setString(4, sb.getStdMother());
			ps.setString(5, sb.getStdAddress());
			ps.setString(6, sb.getStdPartNo());
			ps.setString(7, sb.getAdharNo());
			k=ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
}
