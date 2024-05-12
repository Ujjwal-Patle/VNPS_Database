package login;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		try
		{
			int k = new UpdateStdDAO().updateStd(req);
			PrintWriter pw = res.getWriter();
			if(k>0)
			{
				req.getRequestDispatcher("Dashboard.html").include(req, res);
				pw.print("<font color =red>update successfullly</font>");
			}
			else {
				pw.print("Update fail");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
