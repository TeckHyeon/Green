package com.bitc.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {

	private String drivers = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/testdb?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	private String uid = "testuser";
	private String upw = "1234";
	
	public MemberDao() {
		try {
			Class.forName(drivers);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	각 SQL 실행 메서드
	public int idPwCheck(String userId, String userPw) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT count(*) as cnt FROM t_member ";
		sql += "WHERE user_id = ? ";
		sql += "AND user_pw = ? ";
		sql += "AND deleted_yn = 'N' ";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			result = rs.getInt("cnt");
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		finally {
			try {
				if (rs != null) { rs.close(); }
				if (pstmt != null) { pstmt.close(); }
				if (conn != null) { conn.close(); }
			}
			catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return result;
	}
	
	public MemberDto getUserInfo(String userId) {
		MemberDto member = new MemberDto();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT user_id, user_pw, user_name, user_email, ";
		sql += "user_phone, user_addr, user_gender ";
		sql += "FROM t_member ";
		sql += "WHERE user_id = ? ";
		sql += "AND deleted_yn = 'N' ";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			member.setUserId(rs.getString("user_id"));
			member.setUserPw(rs.getString("user_pw"));
			member.setUserName(rs.getString("user_name"));
			member.setUserEmail(rs.getString("user_email"));
			member.setUserPhone(rs.getString("user_phone"));
			member.setUserAddr(rs.getString("user_addr"));
			member.setUserGender(rs.getString("user_gender"));
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		finally {
			try {
				if (rs != null) { rs.close(); }
				if (pstmt != null) { pstmt.close(); }
				if (conn != null) { conn.close(); }
			}
			catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return member;
	}
	
	
	public int insertMember(MemberDto member) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO t_member";
		sql += "(user_id, user_pw, user_name, user_email, user_phone, ";
		sql += "user_addr, user_gender) ";
		sql += "VALUES (?, ?, ?, ?, ?, ?, ?) ";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPw());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getUserEmail());
			pstmt.setString(5, member.getUserPhone());
			pstmt.setString(6, member.getUserAddr());
			pstmt.setString(7, member.getUserGender());
			
			result = pstmt.executeUpdate();
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		finally {
			try {
				if (pstmt != null) { pstmt.close(); }
				if (conn != null) { conn.close(); }
			}
			catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return result;
	}
}














