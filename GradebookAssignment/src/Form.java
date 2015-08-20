import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
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
    	 String assignment = req.getParameter("assignment");
    	 String grade = req.getParameter("grade");
    	 
    	 try
         {
              Class.forName("oracle.jdbc.driver.OracleDriver");
              Connection con=DriverManager.getConnection("jdbc:oracle:thin:testuser/password@localhost","testdb","password");
              Statement st=con.createStatement();
              System.out.println("connection established successfully...!!");
              
              st.executeQuery ("Insert into GRADES (ASSIGNMENT,GRADE) values ('"+assignment+"',"+grade+")");
  
                  con.close();
                  getServletContext().getRequestDispatcher("/FromDBase").forward(req, res);
         }
         catch (Exception e){
             e.printStackTrace();
         }
    }
}