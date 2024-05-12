package login;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		try {
		int k = new DeleteDAO().deleteStd(req);
		PrintWriter pw =res.getWriter();
		
		if(k>0)
		{
//			res.setContentType("text/html");
			req.getRequestDispatcher("Dashboard.html").include(req, res);
			pw.print("<font color =red>Deletetion sucessfull</font>");
		}
		else
		{
			pw.print("not deleted");
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
