import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Grades;
import customTools.DBUtil;
 
@WebServlet("/Form")
public class Form extends HttpServlet  
{
	static String assignment, grade="";
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		getServletContext().getRequestDispatcher("/Gradebook.jsp").forward(req, res);
		
		}
	
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	EntityManager emf = DBUtil.getEmFactory().createEntityManager();
		model.Grades student = new Grades();
		Insert gr = new Insert();
		String assignment= req.getParameter("assignment");
		String gradeString=  req.getParameter("grade").toString();
		double grade = Double.parseDouble(gradeString);
		
		student.setAssignment(assignment);
		student.setGrade(grade);
		

		gr.insert(student);
                  getServletContext().getRequestDispatcher("/FromDBase").forward(req, res);
         }
        
    }
