package ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestMyMember {
	private static String driver = "oracle.jdbc.OracleDriver";
	private static String url = "jdbc:oracle:thin:@192.168.0.8:1521:xe";
	private static String dbuid = "hth";
	private static String dbpwd = "1234";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, dbuid, dbpwd);
		String sql = "SELECT * FROM MEMBER ";
		Scanner in = new Scanner(System.in);
		System.out.println("검색할 이름: ");
		String sname=in.nextLine();
		sql += " WHERE 이름 LIKE '%" + sname + "%'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);// select
		// int cnt = stmt.executeUpdate(sql);
		// insert, delete,update,create,alter,drop
		while (rs.next()) {
			int num = rs.getInt("번호");
			String name = rs.getString("이름");
			String tel = rs.getString("전화");
			String email = rs.getString("이메일");
			String sex = rs.getString("성별");
			String indate = rs.getString("가입일");
			String fmt = "%d %s %s %s %s %s";
			String msg = String.format(fmt,  num,name,tel,email,sex,indate);
			System.out.println(msg);
			
		}
		rs.close();
		stmt.close();
		conn.close();
		System.out.println(conn.isClosed() ? "접속종료" : "접속중");// 접속중(false), 접속종료(true)
	}

}
