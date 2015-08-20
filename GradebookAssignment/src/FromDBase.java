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
    	 try
         {
              Class.forName("oracle.jdbc.driver.OracleDriver");
              Connection con=DriverManager.getConnection("jdbc:oracle:thin:testuser/password@localhost","testdb","password");
              Statement st=con.createStatement();
              System.out.println("connection established successfully...!!");     
  
              ResultSet rs=st.executeQuery("select * from grades");
  
              course+= "<table border=1>";
              course+= "<tr><th>Assignment</th><th>Grade</th></tr>";
             average= "<table border=1>";
             average= "<tr><th>Average</th><th>Average Grade</th></tr>";
              
                  while(rs.next())
                  {
                 	ass = rs.getString("ASSIGNMENT");
                     gr = rs.getInt("GRADE");
                     String grs = gr.toString();
                    avg += gr;
                    count++;
                   avg2 = Double.toString(avg/count);
                   wAverage = "Average";
                     course+= "<tr><td>" +ass +"</td><td>"+grs+"</td></tr>";
                     average= "<tr><td>" +wAverage+"</td><td>"+avg2+"</td></tr>";
                  }
                  con.close();
       
         }
         catch (Exception e){
             e.printStackTrace();
         }
  
         req.setAttribute("message",course);
         req.setAttribute("message2",average);
 		getServletContext().getRequestDispatcher("/DBaseOutput.jsp").forward(req, res);
 		
    }
}