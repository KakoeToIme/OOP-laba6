package mavenproject.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet(name = "VolumeServlet", value = "/volume-servlet")
public class VolumeServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String function = request.getParameter("function");
        double result = 0;

        switch (function) {
            case "Параллелепипед":
                double Socn;
                double height;

                try {
                    Socn = Double.parseDouble(request.getParameter("AreaOfOsnovaniya"));
                    height = Double.parseDouble(request.getParameter("height"));
                } catch (NumberFormatException e) {
                    out.println("<p>Invalid input for area of osnovaniya or height.</p>");
                    return;
                }

                if (Socn < 0 || height < 0) {
                    out.println("<p>Invalid input - negative number.</p>");
                    return;
                }
                result = Socn * height;
                break;
            case "Куб":
                double side;

                try {
                    side = Double.parseDouble(request.getParameter("side"));
                } catch (NumberFormatException e) {
                    out.println("<p>Invalid input for side.</p>");
                    return;
                }

                if (side < 0) {
                    out.println("<p>Invalid input - negative number.</p>");
                    return;
                }
                result = side * side * side;
                break;
            case "Шар":
                double radius;

                try {
                    radius = Double.parseDouble(request.getParameter("radius"));
                } catch (NumberFormatException e) {
                    out.println("<p>Invalid input for radius.</p>");
                    return;
                }

                if (radius < 0) {
                    out.println("<p>Invalid input - negative number.</p>");
                    return;
                }
                result = (double)4/3 * 3.14 * radius * radius * radius;
                break;
            case "Тетраэдр":
                double Socn2;
                double height2;

                try {
                    Socn2 = Double.parseDouble(request.getParameter("AreaOfOsnovaniya"));
                    height2 = Double.parseDouble(request.getParameter("height"));
                } catch (NumberFormatException e) {
                    out.println("<p>Invalid input for area of osnovaniya or height.</p>");
                    return;
                }

                if (Socn2 < 0 || height2 < 0) {
                    out.println("<p>Invalid input - negative number.</p>");
                    return;
                }
                result = (double)1/3 * Socn2 * height2;
                break;
            case "Элипсоид":
                double a;
                double b;
                double c;

                try {
                    a = Double.parseDouble(request.getParameter("a"));
                    b = Double.parseDouble(request.getParameter("b"));
                    c = Double.parseDouble(request.getParameter("c"));
                } catch (NumberFormatException e) {
                    out.println("<p>Invalid input for a, b or c.</p>");
                    return;
                }

                if (a < 0 || b < 0 || c < 0) {
                    out.println("<p>Invalid input - negative number.</p>");
                    return;
                }
                result = (double)4/3 * 3.14 * a * b * c;
                break;
        }

        out.println("<p>Result: " + result + "</p>");
    }
}
