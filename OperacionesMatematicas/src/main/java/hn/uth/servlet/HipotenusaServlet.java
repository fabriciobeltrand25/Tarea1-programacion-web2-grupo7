package hn.uth.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hipotenusa")
public class HipotenusaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HipotenusaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String metodo = request.getMethod();

		if ("POST".equalsIgnoreCase(metodo)) {

			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();

			double a = 0, b = 0;
			boolean datosValidos = true;

			try {
				a = Double.parseDouble(request.getParameter("catetoA"));
				b = Double.parseDouble(request.getParameter("catetoB"));

				if (a <= 0 || b <= 0) {
					datosValidos = false;
				}
			} catch (Exception e) {
				datosValidos = false;
			}

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Resultado Hipotenusa</title>");
			out.println("<style>\r\n"
					+ "        footer {\r\n"
					+ "            background-color: #222;\r\n"
					+ "            color: white;           \r\n"
					+ "            text-align: center;     \r\n"
					+ "            padding: 15px;          \r\n"
					+ "            position: fixed;        \r\n"
					+ "            bottom: 0;\r\n"
					+ "            width: 100%;\r\n"
					+ "        }\r\n"
					+ "    </style>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1><h1>Universidad Tecnológica de Honduras</h1>");
			out.println("<h2>Programación Web II</h2>");
			out.println("<h3>Desarrolladores: </h3>");
			out.println("<p>Bairon Secundino Pineda Pineda - 202010050071<br>"
					+ "Erik Francisco Pineda Pérez - 202310011128<br>"
					+ "Fabricio Antonio Romero Beltrand - 202410080063</p>");					

			if (!datosValidos) {
				out.println("<h3>Error</h3>");
				out.println("<p>Los valores deben ser mayores que cero.</p>");
			} else {

				double h = Math.sqrt((a * a) + (b * b));

				out.println("<table border='1'>");
				out.println("<tr>");
				out.println("<th>Cateto A</th>");
				out.println("<th>Cateto B</th>");
				out.println("<th>Hipotenusa</th>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>" + a + "</td>");
				out.println("<td>" + b + "</td>");
				out.println("<td>" + h + "</td>");
				out.println("</tr>");
				out.println("</table>");
			}

			out.println("<br><a href='index.html'>Volver al menú</a>");
			out.println("</body>");
			out.println("<footer><p>&copy; 02 de febrero de 2026  | Todos los derechos reservados grupo 7</p></footer>");
			out.println("</html>");
		} else {
			response.getWriter().println("Servlet Hipotenusa activo");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

