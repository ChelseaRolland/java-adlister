import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet(name = "ShowStudentsServlet", urlPatterns = "/students")
@WebServlet("/students")
public class ShowStudentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Use the factory to get the dao object
        Students studentsDao = DaoStudentFactory.getStudentsDao();
        // Use a method on the dao to get all the products
        List<Student> students = studentsDao.all();
        // Pass the data to the jsp
        request.setAttribute("students", students);
        request.getRequestDispatcher("/students/index.jsp").forward(request, response);
    }
}
