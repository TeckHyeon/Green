<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
double v1 = Double.parseDouble(request.getParameter("v1"));
String operator = request.getParameter("operator");
double v2 = Double.parseDouble(request.getParameter("v2"));
double result = 0;
if (operator.equals("+")) {
	result = v1 + v2;
} else {
	if (operator.equals("-")) {
		result = v1 - v2;
	} else {
		if (operator.equals("*")) {
			result = v1 * v2;
		} else {
			if (operator.equals("/")) {
				result = v1 / v2;
			} else {
				out.print("값이 잘못됐습니다");
			}
		}
	}
}
out.print("Served at: " + result);
%>