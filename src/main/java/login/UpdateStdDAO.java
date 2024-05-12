package login;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.http.HttpServletRequest;

public class UpdateStdDAO {
	int k = 0;
	Connection con=null;

	public int updateStd(HttpServletRequest req) {
		try {
			con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement(
					"UPDATE student SET STDNAME = ?, STDCLASS=?, STDMOTHER = ?,STDADDRESS = ?, STDPARTNO = ?,STDADHARNO=? WHERE STDROLLNO=?");
			ps.setString(1, req.getParameter("name"));
			ps.setString(2, req.getParameter("class"));
			ps.setString(3, req.getParameter("mName"));
			ps.setString(4, req.getParameter("add"));
			ps.setString(5, req.getParameter("pNumber"));
			ps.setString(6, req.getParameter("adhar"));

			ps.setString(7, req.getParameter("rollNo"));

			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;

	}

}
