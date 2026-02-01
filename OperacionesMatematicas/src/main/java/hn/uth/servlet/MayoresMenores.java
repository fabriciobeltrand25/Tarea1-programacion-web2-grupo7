package hn.uth.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@WebServlet("/MayoresMenores")
public class MayoresMenores extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MayoresMenores() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String metodo = request.getMethod();

        if ("POST".equalsIgnoreCase(metodo)) {
        	
            // Recibimos los 3 números para los incisos a y b
            int n1 = Integer.parseInt(request.getParameter("n1"));
            int n2 = Integer.parseInt(request.getParameter("n2"));
            int n3 = Integer.parseInt(request.getParameter("n3"));

         // Lógica C: Encontrar el valor que más se repite (la moda)
            String listaStr = request.getParameter("listaNumeros");
            String[] partes = listaStr.split(",");
            Map<Integer, Integer> frecuencias = new HashMap<>();
            int moda = 0;
            int maxRepeticiones = -1;

            for (String s : partes) {
                try {
                    int num = Integer.parseInt(s.trim());
                    // Contamos las veces que aparece cada número
                    int cuenta = frecuencias.getOrDefault(num, 0) + 1;
                    frecuencias.put(num, cuenta);

                    // Actualizamos cuál es el que más se repite
                    if (cuenta > maxRepeticiones) {
                        maxRepeticiones = cuenta;
                        moda = num;
                    }
                } catch (NumberFormatException e) {
                    // Ignorar valores que no sean números válidos
                }
            }
            
         // Al final de la lógica, antes de imprimir:
            String resultadoFinal;
            if (maxRepeticiones <= 1 && partes.length > 1) {
                resultadoFinal = "No hay un valor que se repita más que otros";
            } else {
                resultadoFinal = String.valueOf(moda);
            }



            // Lógica A: Encontrar el mayor de 3
            int mayor = Math.max(n1, Math.max(n2, n3));

            // Lógica B: Encontrar el menor de 3
            int menor = Math.min(n1, Math.min(n2, n3));


         response.setContentType("text/html;charset=UTF-8");
         response.getWriter().println("<!DOCTYPE html>");
         response.getWriter().println("<html>"); // El html abre antes del head
         response.getWriter().println("<head>");
         response.getWriter().println("<meta charset='UTF-8'>");
         response.getWriter().println("<title>RESULTADOS</title>");
         response.getWriter().println("</head>");
         response.getWriter().println("<body>");

         // Imprimir resultados
         response.getWriter().println("<p><b>a. Mayor de ("+n1+", "+n2+", "+n3+"):</b> " + mayor + "</p>");
         response.getWriter().println("<p><b>b. Menor de ("+n1+", "+n2+", "+n3+"):</b> " + menor + "</p>");

         // resultado de "n" 
         response.getWriter().println("<p><b>c. Valor que más se repite:</b> " + resultadoFinal + "</p>");

         response.getWriter().println("<br><a href='index.html'>Regresar al Inicio</a>");
         response.getWriter().println("</body>");
         response.getWriter().println("</html>");
            
        } else {
        	
            response.getWriter().append("Served at: ").append(request.getContextPath());
            response.getWriter().append("\n Proyecto De mayores y menores");
            response.getWriter().append("\n Universidad Tecnologica de Honduras");
            
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

 }

