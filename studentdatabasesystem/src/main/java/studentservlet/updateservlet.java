package studentservlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentdb.studentdb;
import studentmodel.studentmodel;
import studentservices.studentservice;


@WebServlet("/update")

public class updateservlet extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String Name = req.getParameter("Name");
			String Email = req.getParameter("Email");
			String Branch = req.getParameter("Branch");
			String Rollno = req.getParameter("ROllno");
			studentmodel std = new studentmodel(Name,Email,Branch,Rollno);
			studentservice service = new studentservice(studentdb.conn());
			boolean f = service.updatestu(std);
			if(f) {
				resp.sendRedirect("welcome.jsp");
			}
			else {
				resp.sendRedirect("welcome.jsp");
			}
			
		}

	}


