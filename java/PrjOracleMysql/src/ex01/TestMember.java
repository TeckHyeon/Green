package ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class TestMember {
	private static String driver = "oracle.jdbc.OracleDriver";
	private static String url = "jdbc:oracle:thin:@192.168.0.211:1521:xe";
	private static String dbuid = "study01";
	private static String dbpwd = "1234";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ArrayList<Member> members = new ArrayList<>();
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, dbuid, dbpwd);
		String sql = "SELECT * FROM MEMBER";
		Scanner in = new Scanner(System.in);
		System.out.println("검색할 지역 : ");
		String line = in.nextLine();
		sql += " WHERE ADDRESS LIKE '%" + line + "%'";
		System.out.println("sql:"+sql);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			Member member = new Member();
			member.setNum(rs.getInt("NUM"));
			member.setName(rs.getString("NAME"));
			member.setTel(rs.getString("TEL"));
			member.setEmail(rs.getString("EMAIL"));
			member.setAddr(rs.getString("ADDRESS"));
			member.setDate(rs.getString("BIRTH"));
			member.setPoint(rs.getInt("POINT"));
			members.add(member);
		}
		in.close();
		rs.close();
		conn.close();
		for (int i = 0; i < members.size(); i++) {
			Member member = members.get(i);
			String fmt = "%d %s %s %s %s %s %d";
			String msg = String.format(fmt, member.getNum(), member.getName(),
					member.getTel(), member.getEmail(), member.getAddr(), member.getDate(), member.getPoint());
			System.out.println(msg);

		}
	}
}
