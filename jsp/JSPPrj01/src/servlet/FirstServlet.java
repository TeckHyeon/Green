package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/firstservlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//http://localhost:8080/JSPPrj01/firstservlet?v1=3&v2=4
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String v1 = request.getParameter("v1");
		String v2 = request.getParameter("v2");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>Hello 헬로</h2>" + v1);
	}

}
