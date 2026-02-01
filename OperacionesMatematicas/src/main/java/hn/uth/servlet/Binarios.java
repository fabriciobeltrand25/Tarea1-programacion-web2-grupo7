

package hn.uth.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/binarios")
public class Binarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Binarios() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String tipo = request.getParameter("tipo");
		String valor = request.getParameter("valor");

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Resultado</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<h2>Resultado de la conversión</h2>");

		try {
			if ("binarioDecimal".equals(tipo)) {
				int decimal = Integer.parseInt(valor, 2);
				out.println("<p>Binario ingresado: <b>" + valor + "</b></p>");
				out.println("<p>Decimal resultante: <b>" + decimal + "</b></p>");

			} else if ("decimalBinario".equals(tipo)) {
				int decimal = Integer.parseInt(valor);
				String binario = Integer.toBinaryString(decimal);
				out.println("<p>Decimal ingresado: <b>" + decimal + "</b></p>");
				out.println("<p>Binario resultante: <b>" + binario + "</b></p>");
			}
		} catch (NumberFormatException e) {
			out.println("<p style='color:red;'>Error: número inválido</p>");
		}

		out.println("<br>");
		out.println("<a href='index.html'>Volver</a>");

		out.println("</body>");
		out.println("</html>");
	}
}

