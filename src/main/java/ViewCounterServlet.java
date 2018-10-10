import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ViewCounterServlet", urlPatterns = "/count")
public class ViewCounterServlet extends HttpServlet {

    int count = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //setting page type
        res.setContentType("text/html");

        //telling computer to write to webpage
        PrintWriter out = res.getWriter();

        count++;

        //check for reset counter param
        String reset = req.getParameter("reset");
        if (reset != null && reset.equals("true")) {
            count = 0;
        }

        String output = "This page has been viewed " + count + " times.";

        out.println(output);

    }

}
