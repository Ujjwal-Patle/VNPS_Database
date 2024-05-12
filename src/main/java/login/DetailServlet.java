package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Spliterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/detils")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			ArrayList<studentBean> std = new DetailsDAO().details(req);
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			if(std.isEmpty()) {
				pw.print("Not available");
			}
			else
			{
				Spliterator<studentBean> sp = std.spliterator();
				pw.print("<html><head><title>Student Details</title></head><body>");
				pw.print("<h1>Studen Details </h1>");
				pw.print(
						"<table border=solid;><tr><th>Roll no.</th><th>Name</th><th>Class</th><th>Mothers Name</th><th>Parent Number</th><th>Address</th><th>Adhar Number</th></tr>");

				sp.forEachRemaining((e)->{
//					pw.println(e.getStdRollNo() + "&nbsp"+e.getStdName()+"&nbsp"+e.getStdClass()+"&nbsp"+e.getStdMother()+"&nbsp"+e.getStdPartNo()+"&nbsp"+e.getStdAddress()+"&nbsp"+e.getAdharNo()+"<br>");
										pw.print("<tr>");
					pw.println("<td>" + e.getStdRollNo() + "</td>");
					pw.println("<td>" + e.getStdName() + "</td>");
					pw.println("<td>" + e.getStdClass() + "</td>");
					pw.println("<td>" + e.getStdMother() + "</td>");
					pw.println("<td>" + e.getStdPartNo() + "</td>");
					pw.println("<td>" + e.getStdAddress() + "</td>");
					pw.println("<td>" + e.getAdharNo() + "</td>");					
				});
				pw.print("</tr></table>");
				pw.print("</html></body>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
