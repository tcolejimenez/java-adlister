import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //setting page type
        res.setContentType("text/html");

        //telling computer to write to webpage
        PrintWriter out = res.getWriter();

        //getting param passed with get request
        String name = req.getParameter("name");
        if (name == null) {
            name = "World";
        }
        String output = "<h1>Hello, " + name + "!</h1>";

        //puts text onto webpage
        out.println(output);

    }
}
