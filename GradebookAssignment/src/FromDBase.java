import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Grades;
import customTools.DBUtil;
 
@WebServlet("/FromDBase")
public class FromDBase extends HttpServlet  
{
	static String wAverage,average, ass,course,avg2="";
	static Integer gr = 0;
	static Double avg = 0.0;
	static Integer count = 0;
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {     

		}
	
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	EntityManager emf = DBUtil.getEmFactory().createEntityManager();
		
		model.Grades cust = new Grades();
		
		
		// get the list of values to display
	    String line = "<table class=" 
        		+ "\"table table-striped\"" 
        		+ "style=width:60%>";
        
        line += 
 			"<tr>" 
 			+"<th>" + "Assignment" + "</th> <br>"
 			+"<th>" + "Grade" + "</th> <br>"
 			+ "</tr>"
 			;

        for(int i=0; i<Insert.selectPost().size(); i++){
		
        	line += "<tr>" 
        			+"<td>" + Insert.selectPost().get(i).getAssignment()+ "</td>"
        			+"<td>" + Insert.selectPost().get(i).getGrade()+ "</td>"
        			+"</tr>"
        	        ;
        	}
        
        	line += "</table>";
		req.setAttribute("message", line);
		req.setAttribute("message2", Insert.average(cust));
		getServletContext().getRequestDispatcher("/DBaseOutput.jsp").forward(req, res);
		
	}

	}


