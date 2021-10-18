import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class logout extends HttpServlet
{
    public void service(HttpServletRequest req,HttpServletResponse res)
    {
        try {
            // PrintWriter out = res.getWriter();
            HttpSession session = req.getSession(false);

            session.removeAttribute("username");
            session.removeAttribute("password");

            res.sendRedirect("../index.jsp");

        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}