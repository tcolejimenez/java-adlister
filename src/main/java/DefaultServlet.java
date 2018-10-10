import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="DefaultServlet", urlPatterns = "/")
public class DefaultServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //set response page type
        response.setContentType("text/html");

        //telling creates writer to send markup to page
        PrintWriter out = response.getWriter();

        //writes output to page
        out.println("<h1>Welcome to my Page!</h1>");
        out.println("<h2>Here are your options:</h2>");
        out.println("<ul>");
        out.println("<li><a href=\"/hello\">Hello servlet</a></li>");
        out.println("<li><a href=\"/count\">Page View Counter servlet</a></li>");
        out.println("</ul>");

    }
}
