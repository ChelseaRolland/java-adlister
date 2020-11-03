import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CounterServlet", urlPatterns = "/count")
public class CounterServlet extends HttpServlet {

    private int counter = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        counter += 1;

        response.setContentType("text/html");
        PrintWriter out =  response.getWriter();

        out.println("<h1>You have viewed this page: " + counter + " times</h1>");

        String reset = request.getParameter("reset");
        if (reset.equalsIgnoreCase("reset")){
            counter = 0;
            out.println("<h1>PAGE HAS BEEN RESET! You have viewed this page: " + counter + " times</h1>");
        }

//        int resetCounter = Integer.parseInt(request.getParameter("reset"));
//        if (resetCounter == 0) {
//            counter = 0;
//            out.println("<h1>PAGE HAS BEEN RESET! You have viewed this page: " + counter + " times</h1>");
//        } else {
//            out.println("<h1>You have viewed this page: " + counter + " times</h1>");
//        }

    }
}
