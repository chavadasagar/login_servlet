import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class signup extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException
    {
        PrintWriter out = res.getWriter();
        try {
            String name,username,password;
            name = req.getParameter("nm");
            username = req.getParameter("un");
            password = req.getParameter("pw");
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/info1","root","");
            PreparedStatement ps = con.prepareStatement("insert into user(name,username,password) values('"+name+"','"+username+"','"+password+"')");
            int r = ps.executeUpdate();
            if(r>0)
            {
                res.sendRedirect("../home.jsp");
            }
            else{
                out.print("it is else part");
            }

        }
         catch (Exception e) {
            //TODO: handle exception
            out.print(e);
        }
    }
}