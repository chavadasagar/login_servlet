import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class login extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)
    {
        try {
            res.setContentType("text/html");
            HttpSession session = req.getSession(true);
            PrintWriter out = res.getWriter();
            String username,password;
            username = req.getParameter("un");
            password = req.getParameter("pw");


            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/info1","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from user where username='"+username+"' and password='"+password+"'");

            if(rs.next())
            {
                session.setAttribute("username",username);
                session.setAttribute("password",password);
                // RequestDispatcher rd = req.getRequestDispatcher("../home.jsp");
                // rd.forward(req,res);                
                res.sendRedirect("../home.jsp");
            }
            else
            {  
                out.print("<h1>Wrong username or password</h1>");
                // RequestDispatcher rd = req.getRequestDispatcher("../index.jsp");
                // rd.forward(req,res);
                res.sendRedirect("../index.jsp");

            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}