package studentservlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentdb.studentdb;
import studentmodel.studentmodel;
import studentservices.studentservice;

@WebServlet("/register")
public class studentservlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
        String Rollno = req.getParameter("Rollno");
        if (Rollno == null || Rollno.isEmpty()) {
            req.setAttribute("errorMessage", "Rollno cannot be null or empty");
            RequestDispatcher dispatcher = req.getRequestDispatcher("error.jsp");
            dispatcher.forward(req, resp);
            return;
        }

        // Retrieve other parameters
        String Name = req.getParameter("NAME");
        String Email = req.getParameter("EMAIL");
        String Branch = req.getParameter("BRANCH");

        // Create student model object
        studentmodel stu = new studentmodel(Rollno, Name, Email, Branch);

        // Initialize student service with the database connection
        studentservice service = new studentservice(studentdb.conn());

        // Add student using the service
        boolean f = service.addstudent(stu);

        // Redirect based on the result
        if (f) {
            resp.sendRedirect("welcome.jsp");
        } else {
            req.setAttribute("errorMessage", "Error adding student. Please try again.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("error.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
