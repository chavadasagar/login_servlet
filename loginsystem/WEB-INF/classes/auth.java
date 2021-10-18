import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class auth extends HttpServlet
{
    public void service(HttpServletRequest req,HttpServletResponse res)
    {
        try {
            PrintWriter out = res.getWriter();
            HttpSession session = req.getSession(false);
            
            // String username,password;
            // username = (String)session.getValue("username");
            // password = (String)session.getValue("password");

            if(session.getValue("username") == null && session.getValue("password") == null)
            {
                // req.getRequestDispatcher("../index.jsp").include(req,res);
                res.sendRedirect("../index.jsp");
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}