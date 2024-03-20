package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calc.Calc;

// @ : anootation -- 컴파일에게 정보를 제공한다.
// 바로 다음 줄에 있는 함수나 클래스에 영향을 준다,
// @WebServlet("/process02") -- 요청 주소
@WebServlet("/process02")
public class Process02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 넘어온 값을 받는다
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		double v1 = Double.parseDouble(request.getParameter("v1"));
		double v2 = Double.parseDouble(request.getParameter("v2"));
		String op = request.getParameter("op");
		String name = request.getParameter("name");
		

		// 2. 계산한다.
		Calc c1 = new Calc();
		double v_add = c1.add(v1, v2);
		double v_sub = c1.sub(v1, v2);
		double v_mul = c1.mul(v1, v2);
		double v_div = c1.div(v1, v2);
		double result = c1.cal(op,v1, v2);

		// 3. html로 출력한다
		// text/html, alpplication/xml, application/json
		System.out.println(result);
		PrintWriter out = response.getWriter();
		out.println("<h2>결과(서블릿)</h2>\r\n" + "	<h2>\r\n" + result + "	</h2>" + "	<h2>\r\n" + name + "	</h2>");
		out.println("<h2>더하기</h2>\r\n" + "	<h2>\r\n" + v_add + "	</h2>");
		out.println("<h2>빼기</h2>\r\n" + "	<h2>\r\n" + v_sub + "	</h2>");
		out.println("<h2>곱하기</h2>\r\n" + "	<h2>\r\n" + v_mul + "	</h2>");
		out.println("<h2>나누기</h2>\r\n" + "	<h2>\r\n" + Math.round(v_div * 1000) / 1000  + "	</h2>");
		out.flush();
		//out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
