package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;

public class DetailsDAO 
{
	public studentBean std = null;
	public ArrayList<studentBean> details( HttpServletRequest req)
	{
		ArrayList<studentBean> list = new ArrayList<studentBean>();
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("Select * from student where STDCLASS=?");
			ps.setString(1,req.getParameter("class"));
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				std = new studentBean();
				std.setStdName(rs.getString(2));
				std.setAdharNo(rs.getString(7));
				std.setStdAddress(rs.getString(5));
				std.setStdClass(rs.getString(3));
				std.setStdMother(rs.getString(4));
				std.setStdPartNo(rs.getString(6));
				std.setStdRollNo(rs.getString(1));
				list.add(std);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
}
