package login;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class StudentRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public StudentRegServlet() {
        super();
        
    }
    
  
    public static String rollNo ; 
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			studentBean sb = new studentBean();
			sb.setStdName(req.getParameter("name"));
			sb.setStdRollNo(req.getParameter("rollNo"));
			sb.setStdClass(req.getParameter("class"));
			sb.setStdMother(req.getParameter("mName"));
			sb.setStdAddress(req.getParameter("add"));
			sb.setStdPartNo(req.getParameter("pNumber"));
			sb.setAdharNo(req.getParameter("adhar"));
			int k = new StdRegDAO().insertData(sb);
			PrintWriter pw = res.getWriter();
			if(k>0)
			{
				res.setContentType("text/html");
				rollNo=sb.getStdRollNo();
				
				req.getRequestDispatcher("Dashboard.html").include(req, res);
				pw.print("<font color = blueviolet>Registration done</font>");
			}
			else {
				pw.print("Registration not done");				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
