package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	public void init ()
	{
		try {
			 con = DBConnection.getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void destroy() {
		try{
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
		PreparedStatement psmt = con.prepareStatement("select * from admin where adminName =? and password = ?");
		String s1 = request.getParameter("aName");
		String s2 = request.getParameter("password");
		psmt.setString(1, s1);
		psmt.setString(2, s2);
		ResultSet exe = psmt.executeQuery();
		PrintWriter pw = response.getWriter();
		if(exe.next())
		{

			response.sendRedirect("Dashboard.html");
		}
		else {
			response.setContentType("text/html");			
			pw.print("<font color =red>Invalid ID/Password</font>");

			request.getRequestDispatcher("login.html").include(request, response);
		}
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
