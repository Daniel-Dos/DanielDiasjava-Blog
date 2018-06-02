package br.com.danieldiasjava;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloPayaraMicro2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("<h1>Multiplo Deploy</h1>");
	}

}
