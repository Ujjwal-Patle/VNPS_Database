package login;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.http.HttpServletRequest;

public class DeleteDAO 
{	
	Connection con;
	int k=0;
	public int deleteStd(HttpServletRequest req) 
	{
		try {
			con=DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("DELETE FROM student WHERE STDROLLNO=? and STDNAME=?");
			ps.setString(1, req.getParameter("rollNo"));
			ps.setString(2, req.getParameter("name"));
			k = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}

}
